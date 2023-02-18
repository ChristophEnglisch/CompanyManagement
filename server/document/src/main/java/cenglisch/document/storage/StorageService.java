package cenglisch.document.storage;

import cenglisch.document.document.determine.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public void deleteStorageItem(String storageId){
        storageRepository.deleteById(storageId);
    }

    public Storage storeFileContent(String reference, DocumentType documentType, String filePath, String fileContent){
        return storageRepository.saveAndFlush(
                new Storage(
                        reference,
                        filePath,
                        fileContent,
                        documentType
                )
        );
    }

    public Collection<Storage> getStorageItemsByReference(String reference) {
        return storageRepository.findByReference(reference);
    }

    public Collection<Storage> getAllStorageItems() {
        return storageRepository.findAll();
    }
}
