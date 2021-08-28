package its.nugrohodimas.tools;

import its.nugrohodimas.controllers.DepartmentController;
import its.nugrohodimas.controllers.EmployeeController;
import its.nugrohodimas.models.Department;
import its.nugrohodimas.models.Employee;
import its.nugrohodimas.views.DepartmentView;
import its.nugrohodimas.views.EmployeeView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        DBConnection dbc = new DBConnection();
        DepartmentView view = new DepartmentView();
        EmployeeView employeeView = new EmployeeView();
        DepartmentController controller = new DepartmentController(view, dbc.getConnection());

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
            switch (perintah) {
                case "Read":
                    controller.showAllDepartments();
                    break;
                case "Update":
                case "Create":
                    System.out.println("====== List Department ======");
                    controller.showAllDepartments();
                    System.out.println("\n");
                    System.out.println("Template : Id Department (D---),Nama Department,Lokasi,Id Manager(J---)");


                    String[] masukan;
                    masukan = input.nextLine().split(",");

                    Department department = new Department(masukan[0], masukan[1], masukan[2], masukan[3]);
                    controller.showSaveDepartment(department);

                    break;
                case "Delete":
                    System.out.println("====== List Department ======");
                    controller.showAllDepartments();
                    System.out.println("\n");
                    System.out.println("Department mana yang ingin kamu bubarkan : ");
                    String id;
                    id = input.nextLine();
                    controller.showDelete(id);
                    break;
                default:
                    System.out.println("Perintah yang kamu masukan tidak ada!");
                    break;
            }
        } else if (namaTable.equals("Employees")) {
            EmployeeController employeeController = new EmployeeController(employeeView, dbc.getConnection());
            if (perintah.equals("Read")) {
                employeeController.showAllEmployees();
            } else if (perintah.equals("Update") || perintah.equals("Create")) {
                System.out.println("====== List Employee ======");
                employeeController.showAllEmployees();
                System.out.println("\n");

                System.out.println("Masukan ID (J---)");
                String id = input.next();
                System.out.println("Masukan nama pertama");
                String firstName = input.next();
                System.out.println("Masukan nama terakhir");
                String lastName = input.next();
                System.out.println("Masukan email");
                String email = input.next();
                System.out.println("Masukan nomor telepon");
                String numberPhone = input.next();
                System.out.println("Masukan tanggal masuk (ex : 2021-08-02)");
                String date = input.next();
                Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                System.out.println("Masukan gaji");
                int salary = input.nextInt();
                System.out.println("Masukan commision");
                int commision = input.nextInt();
                System.out.println("Masukan Job ID (J--)");
                String jobId = input.next();
                System.out.println("Masukan Manager ID (J---)");
                String managerId = input.next();
                System.out.println("Masukan Department ID (D---)");
                String departmentId = input.next();

                Employee department = new Employee(id, firstName, lastName, email, numberPhone, hireDate, salary,
                        commision, jobId, managerId, departmentId);
                employeeController.showSaveEmployee(department);

            } else if (perintah.equals("Delete")) {
                System.out.println("====== List Employee ======");
                employeeController.showAllEmployees();
                System.out.println("\n");
                System.out.println("Karyawan yang ingin kamu hapus datanya: ");
                String id;
                id = input.nextLine();
                employeeController.showDelete(id);
            } else {
                System.out.println("Perintah yang kamu masukan tidak ada!");
            }
        }
    }
}

