package its.nugrohodimas.views;

import its.nugrohodimas.models.Department;
import its.nugrohodimas.models.Employee;

import java.util.List;

public class EmployeeView {

    public void showAllEmployees(List<Employee> employees) {
        for (Employee d : employees) {
            System.out.println(d.getId() + " - " + d.getFirstName() + " "+ d.getLastName() + " - " +
                    d.getEmail());
        }
    }

    public void showStatusEmployees(boolean status) {
        System.out.println(status?"Query berhasil":"Query gagal");
    }
}
