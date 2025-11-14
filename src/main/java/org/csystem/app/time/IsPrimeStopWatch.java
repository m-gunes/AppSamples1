package org.csystem.app.time;

import com.karandev.io.util.console.Console;
import org.apache.commons.lang3.time.StopWatch;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigDecimal;
import java.math.BigInteger;

public class IsPrimeStopWatch {
    public static void run()
    {
        var stopwatch = new StopWatch();
        stopwatch.start();
        Console.writeLine(NumberUtil.isPrime(710584055392819667L));
        stopwatch.stop();
        Console.writeLine("%f seconds", stopwatch.getNanoTime() / 1_000_000_000.);

        stopwatch.reset();

        stopwatch.start();
        Console.writeLine(NumberUtil.isPrime(BigInteger.valueOf(710584055392819667L)));
        stopwatch.stop();
        Console.writeLine("%f seconds", stopwatch.getNanoTime() / 1_000_000_000.);
    }
}
