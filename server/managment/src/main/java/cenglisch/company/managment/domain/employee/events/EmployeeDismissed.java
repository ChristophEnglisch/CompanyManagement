package cenglisch.company.managment.domain.employee.events;

import cenglisch.company.managment.domain.DomainEvent;
import cenglisch.company.managment.domain.employee.EmployeeId;

public record EmployeeDismissed(EmployeeId employeeId) implements EmployeeEvent {
}
