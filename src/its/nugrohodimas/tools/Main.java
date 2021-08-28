package its.nugrohodimas.tools;

import its.nugrohodimas.controllers.CountryController;
import its.nugrohodimas.controllers.DepartmentController;
import its.nugrohodimas.controllers.EmployeeController;
import its.nugrohodimas.controllers.JobController;
import its.nugrohodimas.controllers.LocationController;
import its.nugrohodimas.controllers.RegionController;
import its.nugrohodimas.models.Country;
import its.nugrohodimas.models.Department;
import its.nugrohodimas.models.Employee;
import its.nugrohodimas.models.Job;
import its.nugrohodimas.models.Location;
import its.nugrohodimas.models.Region;
import its.nugrohodimas.views.CountryView;
import its.nugrohodimas.views.DepartmentView;
import its.nugrohodimas.views.EmployeeView;
import its.nugrohodimas.views.JobView;
import its.nugrohodimas.views.LocationView;
import its.nugrohodimas.views.RegionView;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        Scanner input = new Scanner(System.in);
        DBConnection dbc = new DBConnection();
        DepartmentView view = new DepartmentView();
        EmployeeView employeeView = new EmployeeView();
        RegionView regionView = new RegionView();
        CountryView countryView = new CountryView();
        LocationView locationView = new LocationView();
        JobView jobView = new JobView();
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

        if (namaTable.equals("Regions")) {
            RegionController regionController = new RegionController(regionView, dbc.getConnection());
            if (perintah.equals("Read") || perintah.equals("2")) {
                regionController.showAllRegions();
            } else if (perintah.equals("Update") || perintah.equals("Create") || perintah.equals("1") || perintah.equals("3")){
                System.out.println("====== List Department ======");
                regionController.showAllRegions();
                System.out.print("Masukkan Id Region : ");
                String id = input.nextLine();
                System.out.print("Masukkan Nama Region :");
                String name = input.nextLine();

                Region region = new Region(id, name);

                regionController.saveRegion(region);
                regionController.showAllRegions();
            }
            else if(perintah.equals("Delete") || perintah.equals("4")){
                System.out.println("====== List Department ======");
                regionController.showAllRegions();
                System.out.println("Masukkan Id :");
                String hapus = input.nextLine();
                
                regionController.deleteRegion(hapus);
                System.out.println("Data");
            }
            else{
                System.out.println("Yang Anda masukkan salah !!!");
            }
            System.in.read();
        } else if (namaTable.equals("Countries")){
            CountryController countryController = new CountryController(countryView, dbc.getConnection());
            if (perintah.equals("Read") || perintah.equals("2")) {
                countryController.showAllCountries();
            } else if (perintah.equals("Update") || perintah.equals("Create") || perintah.equals("1") || perintah.equals("3")){
                System.out.println("====== List Department ======");
                countryController.showAllCountries();
                System.out.print("Masukkan Id Country : ");
                String id = input.nextLine();
                System.out.print("Masukkan Nama Country :");
                String name = input.nextLine();
                System.out.print("Masukkan Region Id :");
                String idRegion = input.nextLine();

                Country country = new Country(id, name, idRegion);

                countryController.saveCountry(country);
                countryController.showSaveCountry(country);
            }
            else if(perintah.equals("Delete") || perintah.equals("4")){
                System.out.println("====== List Department ======");
                countryController.showAllCountries();
                System.out.println("Masukkan Id :");
                String hapus = input.nextLine();
                
                countryController.deleteCountry(hapus);
                countryController.showDelete(hapus);
            }
            else{
                System.out.println("Yang Anda masukkan salah !!!");
            }
            System.in.read();
        }else if (namaTable.equals("Locations")){
            LocationController locationController = new LocationController(locationView, dbc.getConnection());
            if (perintah.equals("Read") || perintah.equals("2")) {
                locationController.showAllLocations();
            } else if (perintah.equals("Update") || perintah.equals("Create") || perintah.equals("1") || perintah.equals("3")){
                System.out.println("====== List Department ======");
                locationController.showAllLocations();
                System.out.print("Masukkan Id Location : ");
                String id = input.nextLine();
                System.out.print("Masukkan Street Address :");
                String street = input.nextLine();
                System.out.print("Masukkan Postal Code :");
                String postalCode = input.nextLine();
                System.out.print("Masukkan City :");
                String city = input.nextLine();
                System.out.print("Masukkan State Province :");
                String province = input.nextLine();
                System.out.print("Masukkan Country Id :");
                String countryId = input.nextLine();

                Location location = new Location(id, street, postalCode, city, province, countryId);

                locationController.saveLocation(location);
                locationController.showSaveLocation(location);
            }
            else if(perintah.equals("Delete") || perintah.equals("4")){
                System.out.println("====== List Department ======");
                locationController.showAllLocations();
                System.out.println("Masukkan Id :");
                String hapus = input.nextLine();
                
                locationController.deleteLocation(hapus);
                locationController.showDelete(hapus);
            }
            else{
                System.out.println("Yang Anda masukkan salah !!!");
            }
            System.in.read();
        }else if (namaTable.equals("Jobs")){
            JobController jobController = new JobController(jobView, dbc.getConnection());
            if (perintah.equals("Read") || perintah.equals("2")) {
                jobController.showAllJobs();
            } else if (perintah.equals("Update") || perintah.equals("Create") || perintah.equals("1") || perintah.equals("3")){
                System.out.println("====== List Department ======");
                jobController.showAllJobs();
                System.out.print("Masukkan Id Job : ");
                String id = input.nextLine();
                System.out.print("Masukkan Nama Title :");
                String title = input.nextLine();
                System.out.print("Masukkan Min Salary :");
                Float min = input.nextFloat();
                System.out.print("Masukkan Max Salary :");
                Float max = input.nextFloat();

                Job job = new Job(id, title, min, max);

                jobController.saveJob(job);
                jobController.showSaveJob(job);
            }
            else if(perintah.equals("Delete") || perintah.equals("4")){
                System.out.println("====== List Department ======");
                jobController.showAllJobs();
                System.out.println("Masukkan Id :");
                String hapus = input.nextLine();
                
                jobController.deleteJob(hapus);
                jobController.showDelete(hapus);

            }
        }
    }
        }
    }
}

