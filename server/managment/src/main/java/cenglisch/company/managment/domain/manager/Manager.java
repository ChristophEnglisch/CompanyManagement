package cenglisch.company.managment.domain.manager;

import cenglisch.company.managment.domain.company.CompanyId;

import java.util.List;

public class Manager {
    private ManagerId managerId;

    private String name;

    private List<CompanyId> company;

    public Manager(String name) {
        setName(name);
    }

    public void joinCompany(CompanyId companyId) {
        company.add(companyId);
    }

    public void leaveCompany(CompanyId companyId) {
        company.remove(companyId);
    }

    private void setManagerId(ManagerId managerId) {
        this.managerId = managerId;
    }

    private void setName(String name) {
        this.name = name;
    }

    public ManagerId getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }

    public List<CompanyId> getCompany() {
        return company;
    }
}