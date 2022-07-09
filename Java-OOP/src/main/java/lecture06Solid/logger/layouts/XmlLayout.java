package lecture06Solid.logger.layouts;

import lecture06Solid.logger.interfaces.Layout;
import lecture06Solid.logger.loggers.ReportLevel;

public class XmlLayout implements Layout {
    @Override
    public String format(String timestamp, ReportLevel reportLevel, String message) {
        return "<log>\n" +
                "   <date>" + timestamp + "</date>\n" +
                "   <level>" + reportLevel + "</level>\n" +
                "   <message>" + message + "</message>\n" +
                "</log>";
    }
}
