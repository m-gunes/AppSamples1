package org.csystem.app.localdatetime;

import com.karandev.io.util.console.Console;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BirthdayApp {
    private static void printStatus(int day, int month, int year)
    {
        var today = LocalDate.now();
        var birthDate = LocalDate.of(year, month, day);
        var birthDay = birthDate.withYear(today.getYear());
        var age = ChronoUnit.DAYS.between(birthDate, today) / 365.;

        if (today.isBefore(birthDay))
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);
        else if (today.isAfter(birthDay))
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);
        else
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);
    }
    public static void run()
    {
        var day = Console.readInt("Gün?");
        var month = Console.readInt("Ay?");
        var year = Console.readInt("Yıl?");

        printStatus(day, month, year);
    }
}

