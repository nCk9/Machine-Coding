package org.Logger;

import java.util.List;

public interface CustomLogger {
    public void setLogger(LogLevels logLevel, String message);
    public List<LogEntry> getLogs();
    public List<LogEntry> getLogs(LogLevels logLevel);
}
