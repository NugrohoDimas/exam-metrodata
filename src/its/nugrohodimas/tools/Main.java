package its.nugrohodimas.tools;

import its.nugrohodimas.controllers.DepartmentController;
import its.nugrohodimas.controllers.EmployeeController;
import its.nugrohodimas.models.Department;
import its.nugrohodimas.models.Employee;
import its.nugrohodimas.views.DepartmentView;
import its.nugrohodimas.views.EmployeeView;

import javax.swing.plaf.synth.Region;
import javax.swing.text.View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DBConnection dbc = new DBConnection();
        DepartmentView departmentView = new DepartmentView();
        EmployeeView employeeView = new EmployeeView();

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
            DepartmentController controller = new DepartmentController(departmentView, dbc.getConnection());
            if (perintah.equals("Read")) {
                controller.showAllDepartments();
            } else if (perintah.equals("Update") || perintah.equals("Create")) {
                System.out.println("====== List Department ======");
                controller.showAllDepartments();
                System.out.println("\n");
                System.out.println("Template : Id Department (D---),Nama Department,Lokasi,Id Manager(J---)");


                String[] masukan;
                masukan = input.nextLine().split(",");

                Department department = new Department(masukan[0], masukan[1], masukan[2], masukan[3]);
                controller.showSaveDepartment(department);

            } else if (perintah.equals("Delete")) {
                System.out.println("====== List Department ======");
                controller.showAllDepartments();
                System.out.println("\n");
                System.out.println("Department mana yang ingin kamu bubarkan : ");
                String id;
                id = input.nextLine();
                controller.showDelete(id);
            } else {
                System.out.println("Perintah yang kamu masukan tidak ada!");
            }
        } else if (namaTable.equals("Employees")) {
            EmployeeController controller = new EmployeeController(employeeView, dbc.getConnection());
            if (perintah.equals("Read")) {
                controller.showAllEmployees();
            } else if (perintah.equals("Update") || perintah.equals("Create")) {
                System.out.println("====== List Employee ======");
                controller.showAllEmployees();
                System.out.println("\n");
                System.out.println("Masukan sesuai urutan : Id Department (D---), Nama Awal, Nama Akhir, " +
                        "Email, Nomer Telepon," +
                        " Tanggal Masuk, Gaji, Commision, Job ID (J--), Manager Id (J---), Department ID (D---)");

                String id = input.next();
                String firstName = input.next();
                String lastName = input.next();
                String email = input.next();
                String numberPhone = input.next();

                try {
                    Date hireDate = new SimpleDateFormat("yyyy/MM/dd").parse(input.next());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                int salary = input.nextInt();
                int commision = input.nextInt();
                String jobId = input.next();
                String managerId = input.next();
                String departmentId = input.next();

                Employee department = new Employee(id, firstName, lastName, email, numberPhone, hireDate, salary,
                        commision, jobId, managerId, departmentId);
                controller.showSaveEmployee(department);

            } else if (perintah.equals("Delete")) {
                System.out.println("====== List Employee ======");
                controller.showAllEmployees();
                System.out.println("\n");
                System.out.println("Karyawan yang ingin kamu hapus datanya: ");
                String id;
                id = input.nextLine();
                controller.showDelete(id);
            } else {
                System.out.println("Perintah yang kamu masukan tidak ada!");
            }
        }
    }
}
