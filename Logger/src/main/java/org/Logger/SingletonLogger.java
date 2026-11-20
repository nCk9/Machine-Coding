package org.Logger;

public class SingletonLogger {

    private static volatile CustomLogger loggerInstance;

    private SingletonLogger(){
        loggerInstance = null;
    }

    public static CustomLogger getLoggerInstance(){// if we put synchronized here, all calls will be blocked, even if loggerInstance is already initialized. That leads to performance degradation in highly scalable environments
        if(loggerInstance == null){
            synchronized (SingletonLogger.class) { //double-checked locking for frequent concurrent accesses; acquires class level locking!
                loggerInstance = new InMemoryLogger();
            }
        }
        return loggerInstance;
    }
}
