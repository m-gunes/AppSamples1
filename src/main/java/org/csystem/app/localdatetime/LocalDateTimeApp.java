package org.csystem.app.localdatetime;

import com.karandev.io.util.console.Console;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeApp {
    public static void run()
    {
        printCartExpiryStatus();
    }

    public static void printCartExpiryStatus()
    {
        while (true) {
            var expiryMonth = Console.readInt("Input expiry month:");
            var expiryYear = Console.readInt("Input expiry year:");
            var expiryDate = YearMonth.of(expiryYear, expiryMonth).atEndOfMonth(); // Great!!!

            expiryDate = expiryDate.withDayOfMonth(expiryDate.lengthOfMonth());
            Console.writeLine(expiryDate);
            Console.writeLine(LocalDate.now().isAfter(expiryDate) ? "Card expired" : "Card is available");
        }
    }

    public static void printCartExpiryStatus1()
    {
        while (true) {
            var expiryMonth = Console.readInt("Input expiry month:");
            var expiryYear = Console.readInt("Input expiry year:");
            var expiryDate = LocalDate.of(expiryYear, expiryMonth, 1);
            expiryDate = expiryDate.withDayOfMonth(expiryDate.lengthOfMonth());
            Console.writeLine(expiryDate);
            Console.writeLine(LocalDate.now().isAfter(expiryDate) ? "Card expired" : "Card is available");
        }
    }

    public static void parseFormatter()
    {
        try {
            var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            var date = LocalDate.parse(Console.readLine("Input date text:"), formatter);
            Console.writeLine(date);
        }
        catch (DateTimeException e) {
            Console.Error.writeLine("Invalid format for date");
        }
    }

    public static void patternEx()
    {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyy-HH-mm-s-n");
        var now = LocalDateTime.now();

        Console.writeLine(now);
        Console.writeLine(now.format(formatter));
    }

    public static void printEndOfMonthEx()
    {
//        var endOfTheCurrentMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
        var today = LocalDate.now();
        var endOfMonth1 = today.withDayOfMonth(1).plusMonths(1).minusDays(1);
        var endOfMonth2 = today.with(TemporalAdjusters.lastDayOfMonth());
        var endOfMonth3 = today.withDayOfMonth(today.lengthOfMonth()); // en az maliyetli olan budur!
        Console.writeLine(endOfMonth1);
        Console.writeLine(endOfMonth2);
        Console.writeLine(endOfMonth3);
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
