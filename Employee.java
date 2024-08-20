
public abstract class Employee extends BirthDate {
    private final String firstName;
    private final String lastName;

    // constructor
    public Employee(String firstName, String lastName,int year,int month,int day){
        super(year,month,day);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s: %s",
                getFirstName(), getLastName(),"date of birth",super.toString());
    }
    public abstract double earnings();
}
