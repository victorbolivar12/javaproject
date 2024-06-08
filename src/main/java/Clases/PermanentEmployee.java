
package Clases;


public class PermanentEmployee extends Employee{
    private int yearsOfService;

    public PermanentEmployee(String firstName, String lastName, String idNumber, int numberOfChildren, int yearsOfService) {
        super(firstName, lastName, idNumber, numberOfChildren);
        this.yearsOfService = yearsOfService;
    }

    @Override
    public double calculateSalary() {
        return 20000 + (1000 * numberOfChildren) + (1000 * yearsOfService);
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
    
    
}
