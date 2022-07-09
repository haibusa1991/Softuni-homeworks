package lecture06Solid.logger.appenders;

import lecture06Solid.logger.loggers.ReportLevel;
import lecture06Solid.logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timestamp, ReportLevel reportLevel, String message) {
        if (this.reportLevel.ordinal() > reportLevel.ordinal()) {
            return;
        }
        this.appendsCount++;
        System.out.println(this.layout.format(timestamp, reportLevel, message));
    }

    @Override
    public int getAppendsCount() {
        return this.appendsCount;
    }

}
