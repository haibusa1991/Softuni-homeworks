package lecture06Solid.logger.appenders;


import java.io.File;

public class LogFile extends File {

    public LogFile( String pathname) {
        super(pathname);
    }

    public LogFile() {
        super("default.txt");
    }
}
