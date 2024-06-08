
package Clases;

import java.util.Date;

public class TemporaryEmployee extends Employee {
    private Date startDate;
    private Date endDate;

    public TemporaryEmployee(String firstName, String lastName, String idNumber, int numberOfChildren, Date startDate, Date endDate) {
        super(firstName, lastName, idNumber, numberOfChildren);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public double calculateSalary() {
        return 18000 + (1000 * numberOfChildren);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
}
