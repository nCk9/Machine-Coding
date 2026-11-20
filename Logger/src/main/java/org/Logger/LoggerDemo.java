package org.Logger;

import java.util.List;
import java.util.logging.Logger;

public class LoggerDemo {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CustomLogger logger = SingletonLogger.getLoggerInstance();
        logger.setLogger(LogLevels.INFO, "heyyyyyy");
        logger.setLogger(LogLevels.DEBUG, "heyyyyyy bosss!");
        logger.getLogs();
        logger.getLogs(LogLevels.INFO);
    }
}