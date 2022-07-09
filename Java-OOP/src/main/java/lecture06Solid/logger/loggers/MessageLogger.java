package lecture06Solid.logger.loggers;

import lecture06Solid.logger.interfaces.Appender;

public class MessageLogger extends BaseLogger {


    public MessageLogger(Appender... appender) {
        super(appender);
    }

    @Override
    public void logInfo(String timestamp, String message) {
        append(timestamp, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String timestamp, String message) {
        append(timestamp, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String timestamp, String message) {
        append(timestamp, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String timestamp, String message) {
        append(timestamp, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String timestamp, String message) {
        append(timestamp, ReportLevel.FATAL, message);
    }

    private void append(String timestamp, ReportLevel reportLevel, String message){
        for (Appender appender : appenders) {
            appender.append(timestamp, reportLevel, message);
        }
    }
}
