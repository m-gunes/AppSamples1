package org.csystem.app.time;

import com.karandev.io.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

public class StopWatch {
    public static void main(String[] args)
    {
        currentTimeMillis();
    }

    public static void currentTimeMillis()
    {
        var start = System.currentTimeMillis();
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal degil");
        var end = System.currentTimeMillis();
        var seconds = (end - start) / 1000.;

        Console.writeLine("Duration: %f", seconds);
    }

    public static void nanoTime()
    {
        var start = System.nanoTime();
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal degil");
        var end = System.nanoTime();
        var seconds = (end - start) / 1_000_000_000.;

        Console.writeLine("Duration: %f", seconds);
    }
}
