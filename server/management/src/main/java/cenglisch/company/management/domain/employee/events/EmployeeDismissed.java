package cenglisch.company.management.domain.employee.events;

import cenglisch.company.management.domain.employee.EmployeeId;

public record EmployeeDismissed(EmployeeId employeeId) implements EmployeeEvent {
}
