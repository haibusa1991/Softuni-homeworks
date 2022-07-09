package lecture06Solid.logger.interfaces;

public interface Logger {

    void logInfo(String timestamp, String message);

    void logWarning(String timestamp, String message);

    void logError(String timestamp, String message);


    void logCritical(String timestamp, String message);


    void logFatal(String timestamp, String message);

}
