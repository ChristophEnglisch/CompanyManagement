package cenglisch.document.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StorageRepository extends JpaRepository<Storage, String> {
    Collection<Storage> findByReference(String reference);
}
