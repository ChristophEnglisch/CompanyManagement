package cenglisch.company.managment.domain.employee.events;

import cenglisch.company.managment.domain.ManagementDomainEvent;
import cenglisch.company.managment.domain.employee.EmployeeId;

public record EmployeeCreated(EmployeeId employeeId) implements ManagementDomainEvent {
}
