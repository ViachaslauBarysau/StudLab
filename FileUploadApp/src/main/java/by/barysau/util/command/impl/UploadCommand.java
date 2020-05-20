package by.barysau.util.command.impl;

import by.barysau.util.command.Command;
import by.barysau.util.command.FileApp;

public class UploadCommand implements Command {
    private FileApp fileApp;

    public UploadCommand(FileApp fileApp) {
        this.fileApp = fileApp;
    }

    @Override
    public void execute() {
        fileApp.uploadFile();
    }
}
