import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class ClientTest extends UnitTest {

    @Before
    public void setup() {
        Product.deleteAll();
        Client.deleteAll();
    }

    @Test
    public void createAndRetriveClient() {
        // Create un CLient y guardarlo
        new Client("Mario", "Conocida", "A").save();

        // Buscar un client por el nombre
        Client client = Client.find("byNameAndClassification", "Mario", "A").first();

        // Probar
        assertNotNull(client);
        assertEquals("Mario", client.name);
    }

    @Test
    public void canQueryMyProducts() {
        Client client = new Client("Mario", "Conocida", "A").save();
        client.addProduct("Telefono", "Comunicacion");

        Client dbClient = Client.find("byName", "Mario").first();

        assertEquals(1, Product.count());
        assertEquals(1, dbClient.products.size());
        assertEquals("Telefono", dbClient.products.get(0).name);
    }

}

