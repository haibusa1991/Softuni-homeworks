package lecture06Solid.logger.interfaces;

import lecture06Solid.logger.loggers.ReportLevel;

public interface Layout {

    String format(String timestamp, ReportLevel reportLevel, String message);
}
