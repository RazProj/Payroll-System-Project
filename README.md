### Overview
This project is a Java-based payroll system that calculates the earnings of different types of employees.
The system supports multiple employee types, including salaried employees, hourly employees, commission employees, and piece workers.
Each type of employee has its own unique method of calculating earnings, and the system is designed to demonstrate polymorphism by handling different employee types in a unified way.

### Project Structure

* BasePlusCommissionEmployee.java: Employee with base salary plus commission.
* BirthDate.java: Manages birth date details.
* CommissionEmployee.java: Employee paid by commission.
* Employee.java: Abstract base class for all employees.
* HourlyEmployee.java: Employee paid by the hour.
* PieceWorker.java: Employee paid per piece completed.
* SalariedEmployee.java: Employee with a fixed salary.
* PayrollSystemTest.java: Main class to test the payroll system.
* run.bat: Batch script to compile and run the project.

### How to Run the Program:
* Ensure that you have the Java Development Kit (JDK 8 or higher) installed on your system.
* Open the command line and navigate to the directory containing the program files.
* Run the program using the provided run.bat script, by typing the following command: `java PayrollSystemTest`.
