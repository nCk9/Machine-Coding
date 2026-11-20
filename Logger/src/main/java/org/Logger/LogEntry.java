package org.Logger;

import java.time.LocalDateTime;


public class LogEntry {
    public LocalDateTime timeStamp;
    public LogLevels logLevel;
    public String message;

    public LogEntry(LogLevels logLevel, String message){
        this.logLevel = logLevel;
        this.message = message;
    }

    public String getLogLevel(){
        return this.logLevel.toString();
    }
}
