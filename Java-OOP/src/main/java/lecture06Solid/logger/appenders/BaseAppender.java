package lecture06Solid.logger.appenders;


import lecture06Solid.logger.interfaces.Appender;
import lecture06Solid.logger.interfaces.Layout;
import lecture06Solid.logger.loggers.ReportLevel;

public abstract class BaseAppender implements Appender {
    protected Layout layout;
    protected ReportLevel reportLevel = ReportLevel.INFO;
    protected int appendsCount = 0;

    public BaseAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.toString(),
                this.getAppendsCount());
    }
}
