package cenglisch.company.management.domain.employee.events;

import cenglisch.company.management.domain.ManagementDomainEvent;
import cenglisch.company.management.domain.employee.EmployeeId;

public record EmployeeCreated(EmployeeId employeeId) implements ManagementDomainEvent {
}
