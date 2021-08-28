package its.nugrohodimas.controllers;

import its.nugrohodimas.daos.EmployeeDAO;
import its.nugrohodimas.models.Employee;
import its.nugrohodimas.views.EmployeeView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController implements EmployeeDAO {
    private EmployeeView employeeView;
    private Connection connection;

    public EmployeeController(EmployeeView employeeView, Connection connection) {
        this.employeeView = employeeView;
        this.connection = connection;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("select * from employees")
                    .executeQuery();
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(String id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from employees where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getById(String id) {
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from employees where id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setId(resultSet.getString(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setPhoneNumber(resultSet.getString(5));
                employee.setHireDate(resultSet.getDate(6));
                employee.setSalary(resultSet.getInt(7));
                employee.setCommisionPct(resultSet.getInt(8));
                employee.setJobId(resultSet.getString(9));
                employee.setManajerId(resultSet.getString(10));
                employee.setDepartmentId(resultSet.getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        try {
            boolean isInsert = getById(employee.getId()).getId() == null;
            String query = isInsert
                    ? "INSERT INTO employees(first_name, last_name, email, phone_number" +
                    ", hire_date, salary, comission_pct, job_id, manager_id, department_id, id) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)"
                    : "UPDATE employees SET first_name = ?, last_name = ?, email = ? ," +
                    "phone_number = ?, hire_date = ?, salary = ?, comission_pct = ?, job_id = ?," +
                    " manager_id = ?, department_id = ? WHERE id = ?";

            java.util.Date utilDate = employee.getHireDate();
            System.out.println(utilDate);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            System.out.println(sqlDate);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, sqlDate);
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getCommisionPct());
            preparedStatement.setString(8, employee.getJobId());
            preparedStatement.setString(9, employee.getManajerId());
            preparedStatement.setString(10, employee.getDepartmentId());
            preparedStatement.setString(11, employee.getId());
            System.out.println(preparedStatement);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void showAllEmployees() {
        this.employeeView.showAllEmployees(getAllEmployees());
    }

    public void showSaveEmployee(Employee employee) {
        this.employeeView.showStatusEmployees(saveEmployee(employee));
    }

    public void showDelete(String id) {
        this.employeeView.showStatusEmployees(deleteEmployee(id));
    }
}
