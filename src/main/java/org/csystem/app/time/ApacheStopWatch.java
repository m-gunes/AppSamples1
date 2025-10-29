package org.csystem.app.time;

import com.karandev.io.util.console.Console;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.csystem.util.numeric.NumberUtil;

import java.util.concurrent.TimeUnit;

public class ApacheStopWatch {
    public static void main(String[] args)
    {
        var stopWatch = new StopWatch();
        stopWatch.start();

        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal degil");

        stopWatch.stop();

        var seconds = stopWatch.getTime(TimeUnit.MILLISECONDS) / 1000.;

        Console.writeLine("Duration: %f", seconds);
    }
}
