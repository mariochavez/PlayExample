import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class EmployeeTest extends UnitTest {

    @Test
    public void createAndRetriveEmployee() {
        // Create un Empleado y guardarlo
        new Employee("Mario", "Conocida").save();

        // Buscar un empleado por el nombre
        Employee employee = Employee.find("byName", "Mario").first();

        // Probar
        assertNotNull(employee);
        assertEquals("Mario", employee.name);
    }

}


