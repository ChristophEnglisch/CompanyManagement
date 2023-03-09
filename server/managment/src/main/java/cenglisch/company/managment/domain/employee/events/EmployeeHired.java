package cenglisch.company.managment.domain.employee.events;

import cenglisch.company.managment.domain.DomainEvent;
import cenglisch.company.managment.domain.company.CompanyId;
import cenglisch.company.managment.domain.employee.EmployeeId;

public record EmployeeHired(EmployeeId employeeId, CompanyId companyId) implements EmployeeEvent {
}
