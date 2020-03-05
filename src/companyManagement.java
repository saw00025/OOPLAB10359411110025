import java.util.List;
import java.util.Scanner;

public class companyManagement {


    public  static  void main (String[]args){
        //
       EmployeeDAOlmpl dao=EmployeeDAOlmpl.getInstance();
        //display all



        displayAllEmployee(dao);
        addNewEmployee(dao);

    }
    private static void addNewEmployee(EmployeeDAOlmpl dao){
        Scanner sc =new Scanner( System.in);
        System.out.print("Enter employee id : ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter employee name:");
        String name = sc.nextLine();
        System.out.print("Enter employee position:");
        String position=sc.nextLine();
        System.out.print("Enter employee salary:");
        double salary= Double.parseDouble(sc.nextLine().trim());
        dao.addEmp(new Employee(id,name,position,salary) );
    }

    private static void displayAllEmployee(EmployeeDAO dao) {
        List<Employee>emp=dao.getA11Emp();
        for (Employee e:emp){
            System.out.println(e.toString());
        }
    }

}

