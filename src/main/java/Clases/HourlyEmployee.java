
package Clases;

public class HourlyEmployee extends Employee {
    
   private int hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String idNumber, int numberOfChildren, int hoursWorked) {
        super(firstName, lastName, idNumber, numberOfChildren);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * 100;
    }     

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    
}
