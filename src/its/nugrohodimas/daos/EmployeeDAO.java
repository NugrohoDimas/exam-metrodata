package its.nugrohodimas.daos;

import its.nugrohodimas.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public boolean deleteEmployee(String id);

    public Employee getById(String id);

    public boolean saveEmployee(Employee employee);
}