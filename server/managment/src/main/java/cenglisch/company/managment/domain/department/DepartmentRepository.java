package cenglisch.company.managment.domain.department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, DepartmentId> {
    Optional<Department> findByName(String name);
}
