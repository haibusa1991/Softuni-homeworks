package lecture06Solid.logger.loggers;

import lecture06Solid.logger.interfaces.Appender;
import lecture06Solid.logger.interfaces.Logger;

public abstract class BaseLogger implements Logger {
    protected Appender[] appenders;

    public BaseLogger(Appender... appenders) {
        this.appenders = appenders;
    }
}
