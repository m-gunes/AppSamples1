package org.csystem.app.date;

import com.karandev.io.util.console.Console;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateApp {
    public static void run()
    {
        var staff1 = new Staff("mustafa gunes", "13241324134134", 7, 9, 1989);
        var staff2 = new Staff("ethem gunes", "1324132413000", 5, 3, 1969);
        Console.writeLine("Name: %s, Age: %s", staff1.getName(), staff1.getAge());
        Console.writeLine("Name: %s, Age: %s", staff2.getName(), staff2.getAge());
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


class Staff {
    private static final double DIVIDER = 1000. * 60 * 60 * 24 * 365;
    private String m_name;
    private String m_citizenId;
    private Calendar m_birthdate;

    public Staff(String name, String citizenId, int day, int month, int year)
    {
       m_name = name;
       m_citizenId = citizenId;
       m_birthdate = new GregorianCalendar(year, month-1, day);
    }

    public String getName()
    {
        return m_name;
    }

    public double getAge()
    {
        var now = new GregorianCalendar();
        return (now.getTimeInMillis() - m_birthdate.getTimeInMillis()) / DIVIDER;
    }
}