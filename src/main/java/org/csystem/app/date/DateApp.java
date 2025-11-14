package org.csystem.app.date;

import com.karandev.io.util.console.Console;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateApp {
    public static void run()
    {
        calendarEx();
    }

    public static void dateEx()
    {
        var now = new Date();
        Console.writeLine(now);

        var ms = now.getTime();
        Console.writeLine("Milliseconds: %d", ms);

        var date = new Date(ms);
        Console.writeLine(date);
    }

    public static void calendarEx()
    {
        var now1 = Calendar.getInstance();
        Console.writeLine(now1);

        var now = new GregorianCalendar();
        Console.writeLine(now);

        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d", now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1,
                now.get(Calendar.YEAR), now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
    }
}
