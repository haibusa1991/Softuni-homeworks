package lecture06Solid.logger.appenders;

import lecture06Solid.logger.interfaces.Layout;
import lecture06Solid.logger.loggers.ReportLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileAppender extends BaseAppender {
    private LogFile logFile;
    private int fileSize = 0;

    public FileAppender(Layout layout) {
        super(layout);
        this.logFile = new LogFile();
    }

    @Override
    public void append(String timestamp, ReportLevel reportLevel, String message) {
        if (this.reportLevel.ordinal() > reportLevel.ordinal()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(layout.format(timestamp, reportLevel, message))
                .append(System.lineSeparator());

        try {
            Files.write(Paths.get(logFile.getPath()), sb.toString().getBytes(), StandardOpenOption.APPEND);
            fileSize += getStringSize(sb);
            appendsCount++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getAppendsCount() {
        return this.appendsCount;
    }

    private int getStringSize(StringBuilder sb) {
        int sum = 0;
        for (char c : sb.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sum += c;
            }
        }
        return sum;
    }

    public void setFile(File file) {
        this.logFile = new LogFile(file.getName());
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.fileSize;
    }
}
