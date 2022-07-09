package lecture06Solid.logger.layouts;

import lecture06Solid.logger.loggers.ReportLevel;
import lecture06Solid.logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String timestamp, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", timestamp, reportLevel, message);
    }
}
