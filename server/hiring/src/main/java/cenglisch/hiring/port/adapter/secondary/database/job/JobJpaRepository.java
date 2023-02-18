package cenglisch.hiring.port.adapter.secondary.database.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobJpaRepository extends JpaRepository<JobEntity, String> {
}
