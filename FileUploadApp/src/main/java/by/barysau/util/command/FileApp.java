package by.barysau.util.command;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Data
public class FileApp {

    private Part filePart;
    private List<String> fileList = new ArrayList<>();

    public FileApp() {
    }

    public FileApp(Part filePart) {
        this.filePart = filePart;
    }

    public void uploadFile() {
        log.info("Uploading file...");
        try (InputStream fileContent = filePart.getInputStream();
             OutputStream outputStream = new FileOutputStream(new File(System.getProperty("uploadFolderPath") + filePart.getSubmittedFileName()));) {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            log.warn("Exception while uploading file!", e);
        }
    }


    public void getListFiles() {
        log.info("Collecting list of files...");
        try (Stream<Path> walk = Files.walk(Paths.get(System.getProperty("uploadFolderPath")))) {
            setFileList(walk.filter(Files::isRegularFile)
                    .map(x -> x.getFileName().toString()).collect(Collectors.toList()));
        } catch (IOException e) {
            log.warn("Exception while getting list of files!", e);
        }
    }

}
