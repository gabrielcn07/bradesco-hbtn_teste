import java.util.Date;
import java.util.Calendar;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public String fullName() {
        return this.name + " " + this.surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return this.salary * 12;
    }

    public boolean isMEI() {
        if (calculateYearlySalary() >= 130000) return false;
        if (getAge() <= 18) return false;
        if (anotherCompanyOwner) return false;
        if (pensioner) return false;
        if (publicServer) return false;
        return true;
    }

    private int getAge() {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    // Setters para os testes
    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) { this.anotherCompanyOwner = anotherCompanyOwner; }
    public void setPensioner(boolean pensioner) { this.pensioner = pensioner; }
    public void setPublicServer(boolean publicServer) { this.publicServer = publicServer; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
}
