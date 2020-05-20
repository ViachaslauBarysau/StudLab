package by.barysau.util.validator.impl;

import by.barysau.util.command.FileApp;
import by.barysau.util.command.Uploader;
import by.barysau.util.command.impl.GetCommand;
import by.barysau.util.command.impl.UploadCommand;
import by.barysau.util.validator.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NameValidator implements Validator {
    @Override
    public boolean validate(Object fileName) {

        log.info("Name validation in progress...");

        FileApp fileApp = new FileApp();
        Uploader uploader = new Uploader(new UploadCommand(fileApp), new GetCommand(fileApp));
        uploader.getListFiles();

        List<String> fileList = fileApp.getFileList();

        for (String filename : fileList) {
            if (fileName.equals(filename)) {
                return false;
            }
        }
        return true;
    }
}
