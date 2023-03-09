package cenglisch.company.managment.application.employee;

import cenglisch.company.managment.domain.company.CompanyId;
import cenglisch.company.managment.domain.employee.EmployeeId;

public record HireEmployee(EmployeeId employeeId, CompanyId companyId) {
}
