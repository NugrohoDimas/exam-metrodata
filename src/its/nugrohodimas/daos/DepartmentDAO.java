package its.nugrohodimas.daos;

import its.nugrohodimas.models.Department;

import java.util.List;

public interface DepartmentDAO {

    public List<Department> getAllDepartments();

    public boolean deleteDepartment(String id);

    public Department getById(String id);

    public boolean saveDepartment(Department department);
}
