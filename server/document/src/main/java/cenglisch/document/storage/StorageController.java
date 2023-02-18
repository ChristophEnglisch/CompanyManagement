package cenglisch.document.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("v1/document/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping
    public Collection<Storage> getStorageItems() {
        return storageService.getAllStorageItems();
    }

    @GetMapping("reference")
    public Collection<Storage> getStorageItemsByReference(@RequestParam String reference) {
        return storageService.getStorageItemsByReference(reference);
    }
    @DeleteMapping
    public void deleteStorageItem(@RequestParam String id) {
        storageService.deleteStorageItem(id);
    }
}
