package its.nugrohodimas.daos;

import its.nugrohodimas.models.Department;

import javax.swing.plaf.synth.Region;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface DepartmentDAO {

    public List<Department> getAllDepartments();

    public boolean deleteDepartment(String id);

    public Department getById(String id);

    public boolean saveDepartment(Department department);
}
