import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class ClientTest extends UnitTest {

    @Test
    public void createAndRetriveClient() {
        // Create un CLient y guardarlo
        new Client("Mario", "Conocida", "A").save();

        // Buscar un client por el nombre
        Client client = Client.find("byNameAndClassification", "Mario", "B").first();

        // Probar
        assertNotNull(client);
        assertEquals("Mario", client.name);
    }

}

