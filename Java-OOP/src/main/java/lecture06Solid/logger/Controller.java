package lecture06Solid.logger;

import lecture06Solid.logger.factories.AppenderFactory;
import lecture06Solid.logger.factories.LayoutFactory;
import lecture06Solid.logger.interfaces.Appender;
import lecture06Solid.logger.interfaces.Layout;
import lecture06Solid.logger.interfaces.Logger;
import lecture06Solid.logger.loggers.MessageLogger;
import lecture06Solid.logger.loggers.ReportLevel;

public class Controller {
    private final Appender[] appenders;
    private Logger logger = null;

    public Controller(int appenderCount) {
        appenders = new Appender[appenderCount];
    }

    public void createAppender(String inputData) {
        String[] tokens = inputData.split(" ");
        String appenderType = tokens[0];
        String layoutType = tokens[1];

        LayoutFactory layoutFactory = new LayoutFactory();
        Layout layout = layoutFactory.create(layoutType);

        AppenderFactory appenderFactory = new AppenderFactory();
        Appender appender = appenderFactory.create(appenderType, layout);
        ReportLevel reportLevel;

        if (tokens.length >= 3) {
            reportLevel = ReportLevel.valueOf(tokens[2]);
            appender.setReportLevel(reportLevel);
        }
        addAppender(appender);
    }

    private void addAppender(Appender appender) {
        for (int i = 0; i < appenders.length; i++) {
            if (appenders[i] == null) {
                appenders[i] = appender;
                break;
            }
        }
    }

    public void logMessage(String logMessage) {
        if (logger == null) {
            logger = new MessageLogger(appenders);
        }
        String[] tokens = logMessage.split("\\|");
        ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
        String timestamp = tokens[1];
        String message = tokens[2];

        switch (reportLevel) {
            case INFO:
                logger.logInfo(timestamp, message);
                break;
            case WARNING:
                logger.logWarning(timestamp, message);
                break;
            case ERROR:
                logger.logError(timestamp, message);
                break;
            case CRITICAL:
                logger.logCritical(timestamp, message);
                break;
            case FATAL:
                logger.logFatal(timestamp, message);
                break;
        }
    }

    public String getAppendersInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            sb.append(appender);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
