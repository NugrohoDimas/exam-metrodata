package its.nugrohodimas.tools;

import its.nugrohodimas.controllers.DepartmentController;
import its.nugrohodimas.models.Department;
import its.nugrohodimas.views.DepartmentView;

import javax.swing.plaf.synth.Region;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DBConnection dbc = new DBConnection();
        DepartmentView view = new DepartmentView();

        System.out.println("========================================");
        System.out.println("1. Regions                  1. Create");
        System.out.println("2. Countries                2. Read");
        System.out.println("3. Locations                3. Update");
        System.out.println("4. Departments              4. Delete");
        System.out.println("5. Jobs");
        System.out.println("6. Employees");
        System.out.println("========================================");

        System.out.println("Masukan tabel : ");
        String namaTable = input.nextLine();
        System.out.println("Masukan perintah: ");
        String perintah = input.nextLine();

        if (namaTable.equals("Departments")) {
            DepartmentController controller = new DepartmentController(view, dbc.getConnection());
            if (perintah.equals("Read")) {
                controller.showAllDepartments();
            } else if (perintah.equals("Update") || perintah.equals("Insert")) {
                System.out.println("====== List Department ======");
                controller.showAllDepartments();
                System.out.println("\n");
                System.out.println("Template : Id Department,Nama Department,Lokasi,Id Manager");


                String[] masukan;
                masukan = input.nextLine().split(",");

                Department department = new Department(masukan[0], masukan[1], masukan[2], masukan[3]);

                controller.saveDepartment(department);
                controller.showAllDepartments();
            }
        }
    }
}
