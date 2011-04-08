import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class ProductTest extends UnitTest {

    @Test
    public void createAndRetriveProduct() {
        Client client = new Client("Mario", "Conocida", "A").save();

        Product product1 = new Product("Telefono", "Comunicacion", client).save();
        Product product2 = new Product("Computador", "Trabajo", client).save();

        List<Product> products = Product.find("byClient", client).fetch();

        // Probar
        assertEquals(2, Product.count());

        assertEquals(2, products.size());

        Product dbProduct = products.get(0);
        assertEquals("Telefono", dbProduct.name);
    }

}


