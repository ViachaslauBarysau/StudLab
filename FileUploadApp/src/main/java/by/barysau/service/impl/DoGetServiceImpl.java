package by.barysau.service.impl;

import by.barysau.service.DoGetService;
import by.barysau.util.command.FileApp;
import by.barysau.util.command.Uploader;
import by.barysau.util.command.impl.GetCommand;
import by.barysau.util.command.impl.UploadCommand;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DoGetServiceImpl implements DoGetService {
    @Override
    public List<String> getFilesList() {

        log.info("Trying to get list of files...");

        FileApp fileApp = new FileApp();
        Uploader uploader = new Uploader(new UploadCommand(fileApp), new GetCommand(fileApp));
        uploader.getListFiles();

        log.info("List of files received.");

        return fileApp.getFileList();
    }
}
