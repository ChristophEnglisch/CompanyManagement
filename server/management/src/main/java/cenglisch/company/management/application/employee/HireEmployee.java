package cenglisch.company.management.application.employee;

import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.employee.EmployeeId;

public record HireEmployee(EmployeeId employeeId, CompanyId companyId) {
}
