import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

public class PersonTest {

    private Person person;

    @Before
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1);
        Date birthDate = cal.getTime();
        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary(), 0.01);
    }

    @Test
    public void person_is_MEI() {
        person.setSalary(10000);
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setBirthDate(new Date(80, 0, 1)); // ano 1980
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setSalary(20000);
        person.setAnotherCompanyOwner(true);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setBirthDate(new Date(80, 0, 1));
        assertFalse(person.isMEI());
    }
}
