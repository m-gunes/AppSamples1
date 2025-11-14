package org.csystem.app.date;

import com.karandev.io.util.console.Console;

import java.util.Date;

public class DateApp {
    public static void run()
    {
        dateEx();
    }

    public static void dateEx()
    {
        var now = new Date();
        Console.writeLine(now);
    }
}
