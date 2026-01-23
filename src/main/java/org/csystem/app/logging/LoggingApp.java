package org.csystem.app.logging;

import lombok.extern.java.Log;

import java.util.logging.Logger;

@Log
public class LoggingApp {
//    private static final Logger log = Logger.getLogger(LoggingApp.class.getName());

    public static void run()
    {
        log.severe("SEVERE"); // -> ERRORR/FATAL
        log.warning("WARNING");  // -> WARN
        log.info("INFO");  // -> INFO
        log.config("CONFIG");
        log.fine("FINE");  // -> DEBUG
        log.finer("FINER");
        log.finest("FINEST");  // -> TRACE
    }
}
