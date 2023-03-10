package cenglisch.company.management.domain.department;

import cenglisch.domain.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends Repository<Department, DepartmentId> {
    Optional<Department> findByName(String name);
}
