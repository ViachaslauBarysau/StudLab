package by.barysau.util.command.impl;

import by.barysau.util.command.Command;
import by.barysau.util.command.FileApp;

public class GetCommand implements Command {

    private FileApp fileApp;

    public GetCommand(FileApp fileApp) {
        this.fileApp = fileApp;
    }

    @Override
    public void execute() {
        fileApp.getListFiles();
    }
}
