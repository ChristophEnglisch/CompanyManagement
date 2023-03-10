package cenglisch.company.management.domain.employee;

import cenglisch.company.management.domain.address.AddressId;
import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.department.DepartmentId;

import java.util.Date;

public class Employee {
    private EmployeeId id;

    private AddressId address;

    private CompanyId company;

    private DepartmentId department;

    private String firstname;

    private String lastname;

    private Date birthday;

    public void hireEmployee(CompanyId companyId) {
        setCompany(companyId);
    }

    public void dismissEmployee() {
        company = null;
        department = null;
    }

    private void setId(EmployeeId id) {
        this.id = id;
    }

    private void setAddress(AddressId address) {
        this.address = address;
    }

    private void setCompany(CompanyId company) {
        this.company = company;
    }

    private void setDepartment(DepartmentId department) {
        this.department = department;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public EmployeeId getId() {
        return id;
    }

    public AddressId getAddress() {
        return address;
    }

    public CompanyId getCompany() {
        return company;
    }

    public DepartmentId getDepartment() {
        return department;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthday() {
        return birthday;
    }
}