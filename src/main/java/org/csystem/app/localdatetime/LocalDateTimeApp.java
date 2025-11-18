package org.csystem.app.localdatetime;

import com.karandev.io.util.console.Console;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeApp {
    public static void run()
    {
        chronoUnitEx();
    }

    public static void chronoUnitEx()
    {
        var earthquakeDateTime = LocalDateTime.of(2023, Month.FEBRUARY, 6, 4, 2);
        var now = LocalDateTime.now();
        var days = ChronoUnit.DAYS.between(earthquakeDateTime, now);
        var totalYears = days / 365.;
        var hours = ChronoUnit.HOURS.between(earthquakeDateTime, now);
        var weeks = ChronoUnit.WEEKS.between(earthquakeDateTime, now);
        var years = ChronoUnit.YEARS.between(earthquakeDateTime, now);

        Console.writeLine("Days: %s", days);
        Console.writeLine("Total years: %s", totalYears);
        Console.writeLine("Hours: %s", hours);
        Console.writeLine("weeks: %s", weeks);
        Console.writeLine("Years: %s", years);
    }

    public static void toLocalDateAndTime()
    {
        var now = LocalDateTime.now();
        var date = now.toLocalDate();
        var time = now.toLocalTime();

        Console.writeLine(now);
        Console.writeLine(date);
        Console.writeLine(time);
    }

    public static void atTimeAtDateEx()
    {
        var currentTime = LocalTime.now();
        var today = LocalDate.now();
        var now1 = currentTime.atDate(today);
        var now2 = today.atTime(currentTime);

        Console.writeLine(currentTime);
        Console.writeLine(today);
        Console.writeLine(now1);
        Console.writeLine(now2);
    }

    public static void exceptionEx()
    {
        var day = Console.readInt("Day:");
        var month = Console.readInt("Month:");
        var year = Console.readInt("Year:");

        try {
            var date = LocalDate.of(year, month, day);
            Console.writeLine(date);
        }
        catch (DateTimeException e) {
            Console.Error.writeLine("Invalid date format:%s", e.getMessage());
        }
    }

    public static void withEx()
    {
        var today = LocalDate.now();
        Console.writeLine(today);

        var date = today.withYear(2024).withDayOfMonth(10);
        Console.writeLine(date);
    }

    public static void nowPlusMinusEx()
    {
        var now = LocalDateTime.now();
        var today = LocalDate.now();
        var currentTime = LocalTime.now();

        Console.writeLine(now);
        Console.writeLine(today);
        Console.writeLine(currentTime);

        var dateTime = now.plusWeeks(3).plusDays(1).minusHours(4);
        var date = today.minusMonths(2).minusDays(2);
        var time = currentTime.minusHours(3).plusSeconds(75);

        Console.writeLine(dateTime);
        Console.writeLine(date);
        Console.writeLine(time);
    }

    public static void ofEx()
    {
        var date = LocalDate.of(2025, Month.NOVEMBER, 18);
        var time = LocalTime.of(15, 37, 59, 368);
        var dateTime1 = LocalDateTime.of(2025, Month.NOVEMBER, 18, 15, 37, 59, 368);
        var dateTime2 = LocalDateTime.of(date, time);

        Console.writeLine(date);
        Console.writeLine(time);
        Console.writeLine(dateTime1);
        Console.writeLine(dateTime2);
    }
}
