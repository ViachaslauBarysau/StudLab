package by.barysau.util.command;

public class Uploader {
    Command uploadCommand;
    Command getCommand;

    public Uploader(Command upload, Command show) {
        this.uploadCommand = upload;
        this.getCommand = show;
    }

    public void uploadFile() {
        uploadCommand.execute();
    }

    public void getListFiles() {
        getCommand.execute();
    }

}
