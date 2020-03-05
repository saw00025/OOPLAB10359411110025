import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOlmpl implements EmployeeDAO{
    //set connection
    public static  String driverName = "org.sqlite.JDBC";
    public static String url="jdbc:sqlite:"+"D:/OOPLAB10DATABASEIS/IS_Company.sqlite";
    public  static Connection conn=null;
    //Contant Opertors
    //SQL CRUD
    public static final  String GET_ALL_EMP = "select*from Employee ";
    public static final String ADD_NEW_EMP="insert into Employee"+"(empID,name,position,salary)values(?,?,?)";
    public  static final String FIND_EMP_BY_ID="select*from Employee where empID=?";
    public  static final String UPDATE_EMP_BY_ID="UPDATE Employee" +"set name=?,salary =? where empID=?";
    public  static final String DELETE_EMP="delete from Employee"+"where empID=?";
    //Create  instan
    public static EmployeeDAOlmpl instance=new EmployeeDAOlmpl();
    public static EmployeeDAOlmpl getInstance(){
        return  instance;
    }
    //Constructor
    public EmployeeDAOlmpl(){
        //load cass
        try {
            Class.forName(driverName);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Override
    public List<Employee> getA11Emp() {
        List<Employee>emp=new ArrayList<Employee>();
        try {
            conn= DriverManager.getConnection(url);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(GET_ALL_EMP);
            while (rs.next()){
               int id =rs.getInt(1);
               String name =rs.getString(2);
               String position = rs.getString(3);
               double salary=rs.getDouble(4);
               emp.add(new Employee(id, name, position, salary));

            }
            //close
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void addEmp(Employee emp) {
        try {
            conn=DriverManager.getConnection(url);
            PreparedStatement ps=conn.prepareStatement(ADD_NEW_EMP);
            //set
            ps.setInt(1, emp.getEmpID());
            ps.setString(2 ,emp.getName());
            ps.setString(3,emp.getPosition());
            ps.setDouble(4,emp.getSalary());

            if (ps.execute()==false){
                System.out.println("Aiready add new employee.");
            }else {
                System.out.println("Already add new employee.");
                System.exit(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Employee findEmp(int id) {
        Employee emp =null;

        try {

                conn=DriverManager.getConnection(url);
                PreparedStatement ps = conn.prepareStatement(FIND_EMP_BY_ID);
                //
                ps.setInt(1,id);
                ResultSet rs =ps.executeQuery();

                if (rs.next()){
                    int empid = rs.getInt(1);
                    String name = rs.getString(2);
                    String positio = rs.getString(3);
                    double salary =rs.getDouble(4);
                    emp=new Employee(empid,name,positio,salary);

                }else {
                    System.out.println("Couid ,not found employee ");
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }

    @Override
    public void UpdeteEmp(Employee Emp) {
        conn=DriverManager.getConnection(url);
        PreparedStatement ps=conn.prepareStatement(UpdeteEmp(););
        //set
        ps.setInt(1, emp.getEmpID());
        ps.setString(2 ,emp.getName());
        ps.setString(3,emp.getPosition());
        ps.setDouble(4,emp.getSalary());

    }

    @Override
    public void DeleteEmp(Employee Emp) {
        try {
            conn=DriverManager.getConnection(url);
            PreparedStatement ps=conn.prepareStatement(DELETE_EMP;);
            //
            int rs=

        }
    }
}


