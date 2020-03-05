public class Employee {

    private int empID;
    private String name;
    private  String position;
    private Double Salary;

    //constructor
    //getter and setter
    //toString

    public Employee(int empID, String name, String position, Double salary) {
        this.empID = empID;
        this.name = name;
        this.position = position;
        Salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
