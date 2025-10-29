package org.csystem.app.time;

import com.google.common.base.Stopwatch;
import com.karandev.io.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.concurrent.TimeUnit;

public class GuavaStopWatch {
    public static void main(String[] args)
    {
        var stopWatch = Stopwatch.createStarted();
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal degil");
        stopWatch.stop();

        var seconds = stopWatch.elapsed(TimeUnit.MILLISECONDS) / 1000.;

        Console.writeLine("Duration: %f", seconds);
    }
}
