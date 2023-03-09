package cenglisch.company.managment.domain.employee;

import cenglisch.company.managment.domain.EventHandler;
import cenglisch.company.managment.domain.address.AddressId;
import cenglisch.company.managment.domain.company.CompanyId;
import cenglisch.company.managment.domain.employee.events.EmployeeCreated;
import cenglisch.company.managment.domain.employee.events.EmployeeDismissed;
import cenglisch.company.managment.domain.employee.events.EmployeeEvent;
import cenglisch.company.managment.domain.employee.events.EmployeeHired;

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
        return employeeRepository.findById(employeeId);
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