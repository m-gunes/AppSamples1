package org.csystem.app.logging;

import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j
public class Log4jApp {
//    private static final Logger log = LogManager.getLogger(Log4jApp.class);

    public static void run()
    {
        log.fatal("FATAL");
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");
    }
}
