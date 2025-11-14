package org.csystem.app.time;

import com.karandev.io.util.console.Console;
import org.csystem.diagnostics.StopWatch;
import org.csystem.util.numeric.NumberUtil;

import java.util.concurrent.TimeUnit;

public class DiagnosticStopWatch {
    public static void run()
    {
        var stopWatch = StopWatch.createStarted();
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal degil");
        stopWatch.stop();

        var seconds = stopWatch.elapsedTime(TimeUnit.MILLISECONDS) / 1000.;

        Console.writeLine("Duration: %f", seconds);
    }
}
