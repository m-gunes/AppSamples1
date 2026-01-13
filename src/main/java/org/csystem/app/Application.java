package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.app.studycase.scheduler.timeout.CountDownScheduler;
import org.csystem.app.time.TimeUnitSamples;

import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String[] args)
    {
        CountDownScheduler countDown = new CountDownScheduler(10000, 1000){
//        CountDownScheduler countDown = new CountDownScheduler(10, 1, TimeUnit.SECONDS){
            public void onTick(long remainingMilliseconds)
            {
                Console.writeLine((10000 - remainingMilliseconds));
            }
            public void onFinish()
            {
                Console.writeLine("Finito");
            }
        };

        countDown.start();
    }
}