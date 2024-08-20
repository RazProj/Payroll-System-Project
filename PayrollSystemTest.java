import java.util.Calendar;

public class PayrollSystemTest {
    public static void main(String[] args) {
        Calendar currentDate = Calendar.getInstance();

        // Create objects for various types of employees using their respective constructors.
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("John", "Smith", 1972, 4, 24, 800.00);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Karen", "Price", 1999, 12, 31, 16.75, 40);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        "Sue", "Jones", 1960, 3, 19, 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee(
                        "Bob", "Lewis", 1980, 11, 1, 5000, .04, 300);
        PieceWorker pieceWorker = new PieceWorker("Raz", "Solomon", 1997, 12, 8, 2500, 11);

        // Create an array to hold all types of employee objects.
        Employee[] employees = new Employee[5];

        // Populate the array with Employee objects.
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        // Display a header in the console for employee processing.
        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }

            // Check if the current employee has a birthday this month.
            if (currentEmployee.getMonth() == currentDate.get(Calendar.MONTH) + 1) {

                // If yes, add a birthday bonus of $200 to their earnings.
                System.out.println("Employee celebrates birthday this current month.");
                System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings() + 200);
            } else
                System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
        }
    }
}
