package its.nugrohodimas.models;

import java.util.Date;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private int salary;
    private int commisionPct;
    private String jobId;
    private String manajerId;
    private String departmentId;

    public Employee(String id, String firstName, String lastName, String email, String phoneNumber, Date hireDate,
                    int salary, int commisionPct, String jobId, String manajerId, String departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commisionPct = commisionPct;
        this.jobId = jobId;
        this.manajerId = manajerId;
        this.departmentId = departmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommisionPct() {
        return commisionPct;
    }

    public void setCommisionPct(int commisionPct) {
        this.commisionPct = commisionPct;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getManajerId() {
        return manajerId;
    }

    public void setManajerId(String manajerId) {
        this.manajerId = manajerId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commisionPct=" + commisionPct +
                ", jobId='" + jobId + '\'' +
                ", manajerId='" + manajerId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
