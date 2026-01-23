package org.csystem.app;

import org.csystem.app.annotations.FunctionalInterfaceApp;
import org.csystem.app.annotations.OverrideApp;
import org.csystem.app.logging.Log4jApp;
import org.csystem.app.logging.LoggingApp;
import org.csystem.app.logging.Slf4jApp;

class Application {
    public static void run(String[] args)
    {
        Slf4jApp.run();
    }
}
