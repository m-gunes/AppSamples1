package org.csystem.app.date;

import com.karandev.io.util.console.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BirthdayApp {
    public static void printStatus(int day, int month, int year)
    {
        var now = new GregorianCalendar();
        var today = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        var birthDate = new GregorianCalendar(year, month-1, day);
        var birtDay = new GregorianCalendar(today.get(Calendar.YEAR), month-1, day);
        var age = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365);

        if (today.before(birtDay))
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);
        else if (today.after(birtDay))
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);
        else
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);
    }

    public static void printStatus2(int day, int month, int year)
    {
        var now = new GregorianCalendar();
        var today = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        var birthDate = new GregorianCalendar(year, month - 1, day);
        var birthDay = new GregorianCalendar(today.get(GregorianCalendar.YEAR), month - 1, day);
        var age = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365);

        var res = today.compareTo(birthDay);

        if (res > 0)
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);
        else if (res < 0)
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);
        else
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("input your birthday, day month year:");
        int day = kb.nextInt();
        int month = kb.nextInt();
        int year = kb.nextInt();
        printStatus2(day, month, year);
    }
}
