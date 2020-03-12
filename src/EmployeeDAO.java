import java.util.List;

public interface EmployeeDAO {

    //CRUD
    public List<Employee>getA11Emp();
    public void  addEmp (Employee employee);
    public  Employee findEmp(int id);
    public void UpdeteEmp(Employee Emp);
    public  void DeleteEmp (int id);
    }

