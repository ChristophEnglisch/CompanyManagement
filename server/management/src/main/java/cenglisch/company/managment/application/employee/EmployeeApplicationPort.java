package cenglisch.company.management.application.employee;

import cenglisch.company.management.domain.employee.EmployeeService;

public class EmployeeApplicationPort {

    private final EmployeeService employeeService;

    public EmployeeApplicationPort(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void hireEmployee(HireEmployee hireEmployee){
        employeeService.hireEmployee(hireEmployee.employeeId(), hireEmployee.companyId());
    }

    public void dismissEmployee(DismissEmployee dismissEmployee){
        employeeService.dismissEmployee(dismissEmployee.employeeId());
    }
}
