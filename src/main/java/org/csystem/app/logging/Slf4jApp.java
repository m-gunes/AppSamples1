package org.csystem.app.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Slf4jApp {
//    private static final Logger log = LoggerFactory.getLogger(Slf4jApp.class);

    public static void run()
    {
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");
    }
}
