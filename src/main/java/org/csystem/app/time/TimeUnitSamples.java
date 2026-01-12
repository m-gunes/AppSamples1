package org.csystem.app.time;

import com.karandev.io.util.console.Console;

import java.util.concurrent.TimeUnit;

public class TimeUnitSamples {
    public static void run()
    {
        toXXX();
    }

    public static void toXXX()
    {
        while (true) {
            var days = Console.readLong("Input days left:");
            if (days <= 0)
                break;

            var hour = TimeUnit.DAYS.toHours(days);
            Console.writeLine("%d days is %d hours",  days, hour);
        }
    }

    public static void convertEx()
    {
        while (true) {
            var days = Console.readLong("Input days left:");
            if (days <= 0)
                break;

            var hour = TimeUnit.HOURS.convert(days, TimeUnit.DAYS);
            Console.writeLine("%d days is %d hours",  days, hour);
        }
    }

}
