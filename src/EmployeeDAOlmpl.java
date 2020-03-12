import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOlmpl implements EmployeeDAO {
    //set connection
    public static String driverName = "org.sqlite.JDBC";
    public static String url = "jdbc:sqlite:" + "D:/OOPLAB10DATABASEIS/IS_Company.sqlite";
    public static Connection conn = null;
    //Contant Opertors
    //SQL CRUD

    //CRUD
    public static final String GET_All_emp = "select * from Employee";
    public static final String ADD_EMP = "insert into Employee" +
            "(empID,name,position,salary) values (?,?,?,?)";
    public static final String UPDATE_EMP = "update Employee set" +
            " name = ?, position = ?, salary = ? where empID = ?";
    public static final String DELETE_EMP = "delete from Employee" +
            " where empID = ?";
    public static final String FIND_ENP_BY_ID = "select * from Employee" +
            " where empID = ?";
    //create class instant
    private static EmployeeDAOlmpl instant = new EmployeeDAOlmpl();

    public static EmployeeDAOlmpl getInstance() {

        return instant;

    }
    //constructor


    public EmployeeDAOlmpl() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver load successfully.");


    }



    @Override
    public List<Employee> getA11Emp() {
        List<Employee> emp = new ArrayList<Employee>();

        try {
            conn = DriverManager.getConnection((url));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_All_emp);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String position = rs.getString(3);
                double salary = rs.getDouble(4);
                //add data to abject
                emp.add(new Employee(id, name, position, salary));
            }
            //close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void addEmp(Employee newEmp) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(ADD_EMP);
            //set parameter
            ps.setInt(1, newEmp.getEmpID());
            ps.setString(2, newEmp.getName());
            ps.setString(3, newEmp.getPosition());
            ps.setDouble(4, newEmp.getSalary());
            boolean rs = ps.execute();
            if (rs == true) {
                System.out.println("Could not add data tob database");
                //close connection
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    

    @Override
    public Employee findEmp(int id) {
        Employee emp = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(FIND_ENP_BY_ID);
            //set parameter
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int empid = rs.getInt(1);
                String name = rs.getString(2);
                String position = rs.getString(3);
                double salary = rs.getDouble(4);

                emp = new Employee(empid, name, position, salary);

            } else {
                System.out.println("Cloud not found Employee" +
                        "with empID" + id);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;

    }

    @Override
    public void UpdeteEmp(Employee Emp) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(UPDATE_EMP);
            //set parameter
            ps.setString(1, Emp.getName());
            ps.setString(1, Emp.getPosition());
            ps.setDouble(1, Emp.getSalary());
            ps.setInt(1, Emp.getEmpID());


            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Data with empID"
                        + Emp.getEmpID() + "was update.");
            } else {
                System.out.println("Cloud not update data with empID"
                        + Emp.getEmpID());
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void DeleteEmp(int id) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(DELETE_EMP);
            //
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Employee with empID " + id + "was deleted.");
            } else {
                System.out.println("Cloud not deleted Employee" + "with empID" + id);
            }
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
        



                