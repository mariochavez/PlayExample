import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;
import java.util.*;
import java.io.*;

public class ClientsTest extends FunctionalTest {

    public Client client = null;

    @org.junit.Before
    public void setup() {
        Product.deleteAll();
        Client.deleteAll();
        client = new Client("Mario", "Conocida", "A").save();
    }

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/clients");
        assertIsOk(response);
        assertContentType("text/html", response);
    }

    @Test
    public void testThatNewPageWorks() {
        Response response = GET("/clients/new");
        assertIsOk(response);
        assertContentType("text/html", response);
    } 

    @Test
    public void testThatCreateWorks() {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("client.name", "Mario");
        parameters.put("client.address", "Conocida");
        parameters.put("client.classification", "A");

        Map<String, File> files = new HashMap<String, File>();

        Response response = POST("/clients/create", parameters, files);
        assertStatus(302, response);
    }

    @Test
    public void testThatEditPageWorks() {
        Response response = GET("/clients/" + client.id + "/edit");
        assertIsOk(response);
        assertContentType("text/html", response);
    } 

    @Test
    public void testThatUpdateWorks() {
        Response response = PUT("/clients/update", "application/x-www-form-urlencoded", 
"client.id=" + client.id + "&client.name=Mario&client.address=Conocida&client.classification=A");

        assertStatus(302, response);
    }

    @Test
    public void testThatDeleteWorks() {
        Response response = DELETE("/clients/destroy?id=" + client.id);

        assertStatus(302, response);
    }
}

