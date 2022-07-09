package lecture06Solid.logger.factories;

import lecture06Solid.logger.appenders.ConsoleAppender;
import lecture06Solid.logger.appenders.FileAppender;
import lecture06Solid.logger.interfaces.Appender;
import lecture06Solid.logger.interfaces.Layout;

public class AppenderFactory {
    public Appender create(String type, Layout layout) {
        switch (type){
            case "ConsoleAppender":
                return new ConsoleAppender(layout);
            case "FileAppender":
                return new FileAppender(layout);
            default:
                throw new IllegalArgumentException("No such appender - " + type);
        }
    }
}
