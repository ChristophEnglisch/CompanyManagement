package cenglisch.company.management.domain.employee;

import cenglisch.company.management.domain.address.AddressId;
import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.employee.events.EmployeeCreated;
import cenglisch.company.management.domain.employee.events.EmployeeDismissed;
import cenglisch.company.management.domain.employee.events.EmployeeEvent;
import cenglisch.company.management.domain.employee.events.EmployeeHired;
import cenglisch.domain.model.EventHandler;

import java.util.Optional;
import java.util.function.Consumer;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EventHandler eventHandler;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            EventHandler eventHandler
    ) {
        this.employeeRepository = employeeRepository;
        this.eventHandler = eventHandler;
    }

    private Optional<Employee> find(EmployeeId employeeId) {
        return employeeRepository.find(employeeId);
    }

    public void newEmployee(AddressId addressId){
        Employee employee = employeeRepository.save(new Employee());
        eventHandler.publish(new EmployeeCreated(employee.getId()));
    }

    public void hireEmployee(EmployeeId employeeId, CompanyId companyId) {
        manageEmployee(
                employeeId,
                employee -> employee.hireEmployee(companyId),
                new EmployeeHired(employeeId, companyId)
        );
    }

    public void dismissEmployee(EmployeeId employeeId) {
        manageEmployee(
                employeeId,
                Employee::dismissEmployee,
                new EmployeeDismissed(employeeId)
        );
    }

    private void manageEmployee(EmployeeId employeeId, Consumer<Employee> action, EmployeeEvent employeeEvent) {
        Employee employee = find(employeeId).orElseThrow(EmployeeNotFoundException::new);
        action.accept(employee);
        employeeRepository.save(employee);
        eventHandler.publish(employeeEvent);
    }
}