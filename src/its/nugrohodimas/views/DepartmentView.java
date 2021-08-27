package its.nugrohodimas.views;

import its.nugrohodimas.models.Department;

import java.util.List;

public class DepartmentView {

    public void showAllDepartments(List<Department> departments) {
        for (Department d : departments) {
            System.out.println(d.getId() + " - " + d.getName() + " - " + d.getLocationId() + " - " +
                    d.getManagerId());
        }
    }

    public void showStatusDepartments(boolean status) {
        System.out.println(status?"Query berhasil":"Query gagal");
    }
}
