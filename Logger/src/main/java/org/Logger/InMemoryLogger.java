package org.Logger;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLogger implements CustomLogger{

    List<LogEntry> logs;
    InMemoryLogger(){
        logs = new ArrayList<>();
    }
    @Override
    public void setLogger(LogLevels logLevel, String message){
        LogEntry logEntry = new LogEntry(logLevel, message);
        logs.add(logEntry);
    }

    @Override
    public List<LogEntry> getLogs(){
        for(LogEntry entry: logs){
            System.out.print(entry.message);
        }
        return logs;
    }

    public List<LogEntry> getLogs(LogLevels logLevel){
        List<LogEntry> logss = new ArrayList<>();
        for(LogEntry entry: logs){
            if(entry.getLogLevel().equalsIgnoreCase(logLevel.toString())) {
                System.out.println(entry.message);
                        logss.add(entry);
            }
        }
        return logss;
    }
}
