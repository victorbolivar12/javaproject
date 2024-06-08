
package Clases;


public abstract class Employee {
    private String firstName;
    private String lastName;
    private String idNumber;
    int numberOfChildren;

    public Employee(String firstName, String lastName, String idNumber, int numberOfChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.numberOfChildren = numberOfChildren;
    }
    
    public abstract double calculateSalary();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
    
    
}
