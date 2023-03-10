package cenglisch.company.management.domain.employee.events;

import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.employee.EmployeeId;

public record EmployeeHired(EmployeeId employeeId, CompanyId companyId) implements EmployeeEvent {
}
