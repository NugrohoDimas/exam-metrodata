package its.nugrohodimas.controllers;

import its.nugrohodimas.daos.DepartmentDAO;
import its.nugrohodimas.models.Department;
import its.nugrohodimas.views.DepartmentView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentController implements DepartmentDAO {
    private DepartmentView departmentView;
    private Connection connection;


    public DepartmentController(DepartmentView departmentView, Connection connection) {
        this.departmentView = departmentView;
        this.connection =  connection;
    }


    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("select * from departments")
                    .executeQuery();
            while (resultSet.next()) {
                departments.add(new Department(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public boolean deleteDepartment(String id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from departments where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Department getById(String id) {
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from departments where id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                department.setId(resultSet.getString(1));
                department.setName(resultSet.getString(2));
                department.setLocationId(resultSet.getString(3));
                department.setManagerId(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public boolean saveDepartment(Department department) {
        try {
            boolean isInsert = getById(department.getId()).getId() == null;
            String query = isInsert
                    ? "INSERT INTO departments(name, location_id, manager_id, id) VALUES (?,?,?,?)"
                    : "UPDATE departments SET name = ?, location_id = ?, manager_id = ? WHERE id = ?";


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getLocationId());
            preparedStatement.setString(3, department.getManagerId());
            preparedStatement.setString(4, department.getId());
            System.out.println(preparedStatement);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void showAllDepartments() {
        this.departmentView.showAllDepartments(getAllDepartments());
    }

    public void showSaveDepartment(Department department) {
        this.departmentView.showStatusDepartments(saveDepartment(department));
    }

    public void showDelete(String id) {
        this.departmentView.showStatusDepartments(deleteDepartment(id));
    }
}
