package by.barysau.service.impl;

import by.barysau.service.DoPostService;
import by.barysau.util.command.FileApp;
import by.barysau.util.command.Uploader;
import by.barysau.util.command.impl.GetCommand;
import by.barysau.util.command.impl.UploadCommand;
import by.barysau.util.validator.ValidateExecutor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Part;

@Slf4j
public class DoPostServiceImpl implements DoPostService {
    @Override
    public String uploadFile(Part filePart) {
        String message = "";

        if (filePart.getSubmittedFileName().equals("")) {
            log.info("File to upload not found!");
            message = "Select a file to upload, please!";
        } else {
            log.info("Start validation...");
            message = ValidateExecutor.validateFile(filePart);
        }

        if (message.equals("")) {

            FileApp fileApp = new FileApp(filePart);
            Uploader uploader = new Uploader(new UploadCommand(fileApp), new GetCommand(fileApp));
            uploader.uploadFile();
            message = "File Uploaded!";

            log.info("File uploaded succesfully");
        }
        return message;
    }
}
