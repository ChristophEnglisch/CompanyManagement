package cenglisch.document.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSystemService {

    private final String UPLOAD_FOLDER = "upload";

    private final long MAX_FILE_SIZE = FileUtils.ONE_MB * 10;

    public File storeMultipartFile(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            throw new EmptyFileException();
        }

        if (multipartFile.getSize() > MAX_FILE_SIZE){
            throw new FileSizeLimitExceededException();
        }

        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);

            return path.toFile();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}