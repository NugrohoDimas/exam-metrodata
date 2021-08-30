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

        switch (namaTable) {
            case "Departments":
                DepartmentController controller = new DepartmentController(view, dbc.getConnection());
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

                        System.out.println("Masukan ID Department (D---) : ");
                        String id = input.next();
                        System.out.println("Masukan Nama Departemen : ");
                        String name = input.next();
                        System.out.println("Masukan Lokasi Departemen : ");
                        String location = input.next();
                        System.out.println("Masukan ID Manager (J---) : ");
                        String idManager = input.next();

                        Department department = new Department(id, name, location, idManager);
                        controller.showSaveDepartment(department);

                        break;
                    case "Delete":
                        System.out.println("====== List Department ======");
                        controller.showAllDepartments();
                        System.out.println("\n");
                        System.out.println("Department mana yang ingin kamu bubarkan : ");
                        String idDepartmen = input.nextLine();
                        System.out.println("Apakah kamu yakin? ya/tidak");
                        String confirm = input.next();
                        if (confirm.equals("ya")) {
                            controller.showDelete(idDepartmen);
                        } else {
                            main(null);
                        }
                        break;
                    default:
                        System.out.println("Perintah yang kamu masukan tidak ada!");
                        break;
                }
                break;
            case "Employees":
                EmployeeController employeeController = new EmployeeController(employeeView, dbc.getConnection());
                switch (perintah) {
                    case "Read":
                        employeeController.showAllEmployees();
                        break;
                    case "Update":
                    case "Create": {
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

                        break;
                    }
                    case "Delete": {
                        System.out.println("====== List Employee ======");
                        employeeController.showAllEmployees();
                        System.out.println("\n");
                        System.out.println("Karyawan yang ingin kamu hapus datanya: ");
                        String id = input.nextLine();
                        System.out.println("Apakah kamu yakin? ya/tidak");
                        String confirm = input.next();
                        if (confirm.equals("ya")) {
                            employeeController.showDelete(id);
                        } else {
                            main(null);
                        }
                        break;
                    }
                    default:
                        System.out.println("Perintah yang kamu masukan tidak ada!");
                        break;
                }
                break;
            case "Regions":
                RegionController regionController = new RegionController(regionView, dbc.getConnection());
                switch (perintah) {
                    case "Read":
                    case "2":
                        regionController.showAllRegions();
                        break;
                    case "Update":
                    case "Create":
                    case "1":
                    case "3":
                        System.out.println("====== List Department ======");
                        regionController.showAllRegions();
                        System.out.print("Masukkan Id Region : ");
                        String id = input.nextLine();
                        System.out.print("Masukkan Nama Region :");
                        String name = input.nextLine();

                        Region region = new Region(id, name);

                        regionController.saveRegion(region);
                        regionController.showAllRegions();
                        break;
                    case "Delete":
                    case "4":
                        System.out.println("====== List Department ======");
                        regionController.showAllRegions();
                        System.out.println("Masukkan Id :");
                        String hapus = input.nextLine();

                        regionController.deleteRegion(hapus);
                        System.out.println("Data");
                        break;
                    default:
                        System.out.println("Yang Anda masukkan salah !!!");
                        break;
                }
                System.in.read();
                break;
            case "Countries":
                CountryController countryController = new CountryController(countryView, dbc.getConnection());
                switch (perintah) {
                    case "Read":
                    case "2":
                        countryController.showAllCountries();
                        break;
                    case "Update":
                    case "Create":
                    case "1":
                    case "3":
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
                        break;
                    case "Delete":
                    case "4":
                        System.out.println("====== List Department ======");
                        countryController.showAllCountries();
                        System.out.println("Masukkan Id :");
                        String hapus = input.nextLine();
                        System.out.println("Apakah kamu yakin? ya/tidak");
                        String confirm = input.next();
                        if (confirm.equals("ya")) {
                            countryController.deleteCountry(hapus);
                        } else {
                            main(null);
                        }
                        countryController.showDelete(hapus);
                        break;
                    default:
                        System.out.println("Yang Anda masukkan salah !!!");
                        break;
                }
                System.in.read();
                break;
            case "Locations":
                LocationController locationController = new LocationController(locationView, dbc.getConnection());
                switch (perintah) {
                    case "Read":
                    case "2":
                        locationController.showAllLocations();
                        break;
                    case "Update":
                    case "Create":
                    case "1":
                    case "3":
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
                        break;
                    case "Delete":
                    case "4":
                        System.out.println("====== List Department ======");
                        locationController.showAllLocations();
                        System.out.println("Masukkan Id :");
                        String hapus = input.nextLine();
                        System.out.println("Apakah kamu yakin? ya/tidak");
                        String confirm = input.next();
                        if (confirm.equals("ya")) {
                            locationController.deleteLocation(hapus);
                        } else {
                            main(null);
                        }
                        locationController.showDelete(hapus);
                        break;
                    default:
                        System.out.println("Yang Anda masukkan salah !!!");
                        break;
                }
                System.in.read();
                break;
            case "Jobs":
                JobController jobController = new JobController(jobView, dbc.getConnection());
                switch (perintah) {
                    case "Read":
                    case "2":
                        jobController.showAllJobs();
                        break;
                    case "Update":
                    case "Create":
                    case "1":
                    case "3":
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
                        break;
                    case "Delete":
                    case "4":
                        System.out.println("====== List Department ======");
                        jobController.showAllJobs();
                        System.out.println("Masukkan Id :");
                        String hapus = input.nextLine();
                        System.out.println("Apakah kamu yakin? ya/tidak");
                        String confirm = input.next();
                        if (confirm.equals("ya")) {
                            jobController.deleteJob(hapus);
                        } else {
                            main(null);
                        }
                        jobController.showDelete(hapus);

                        break;
                }
                break;
        }
    }
}


