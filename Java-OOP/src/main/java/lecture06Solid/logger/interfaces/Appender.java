package lecture06Solid.logger.interfaces;

import lecture06Solid.logger.loggers.ReportLevel;

public interface Appender {


    void append(String timestamp, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);

    int getAppendsCount();
}
