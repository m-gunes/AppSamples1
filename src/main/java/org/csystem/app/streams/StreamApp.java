package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.factory.StaffFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;


public class StreamApp {
    public static void run(String[] args)
    {
//        getProductGraterThenGivenStock(args);
//        getBetweenStock(args);
//        getBetweenCost(args);
//        getBetweenDates(args);
//        getBetweenYears(args);
//        getStaffsOnLeave(args);
        getStaffsOnLeaveWithShortcut(args);
    }

    private static void firstEx(String[] args)
    {
        var threshold = new BigDecimal(Console.readDouble("Threshold:"));
        try {
            ProductFactory.loadFromTextFile(args[0]).get().PRODUCTS
                    .stream()
//                    .filter(p -> p.getStock() <= 0)
                    .filter(p -> p.getStock() > 0)
                    .filter(p -> p.getCost().compareTo(threshold) > 0)
                    .forEach(Console::writeLine);
        } catch (Exception e) {
            Console.Error.writeLine("Error while loading product file: %s", e.getMessage());
        }
    }

    // 1. Aşağıdaki demo örnekte komut satırından alınan stok miktarından daha fazla stoğu olan ürünler listelenmiştir
    private static void dataExistCallback(ProductFactory productFactory, int stock)
    {
        productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > stock)
                .forEach(Console::writeLine);
    }

    private static void getProductGraterThenGivenStock(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(pf -> dataExistCallback(pf, Integer.parseInt(args[1])), () -> Console.Error.writeLine("Data not exist!..."));
        } catch (NumberFormatException ignore) {
            Console.Error.writeLine("Stock value must be an integer number!...");
        } catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        } catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // 2. Aşağıdaki demo örnekte komut satırından alınan minStock ve maxStock değerlerine göre [minStock, maxStock] aralığında stoğa sahip ürünler listelenmiştir
    private static void dataExistCallback(ProductFactory productFactory, int minStock, int maxStock)
    {

        // solution 1:
        productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > minStock)
                .filter(p -> p.getStock() < maxStock)
                .forEach(Console::writeLine);
        // solution 2:
//        productFactory.PRODUCTS.stream()
//                .filter(p -> minStock <= p.getStock() && p.getStock() <= maxStock)
//                .forEach(Console::writeLine);

        // Hangisi efektif? ikiside ayni
        // Intermediate metotlar isaret koyuyorlar.

    }

    private static void getBetweenStock(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(
                            pf -> dataExistCallback(pf, Integer.parseInt(args[1]), Integer.parseInt(args[2])),
                            () -> Console.Error.writeLine("Data not exist!...")
                    );
        } catch (NumberFormatException ignore) {
            Console.Error.writeLine("Stock value must be an integer number!...");
        } catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        } catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // 3.Aşağıdaki demo örnekte komut satırından alınan minCost ve maxCost değerlerine göre [minCost, maxCost] aralığında maliyete sahip ürünler listelenmiştir
    private static void dataExistCallback(ProductFactory productFactory, BigDecimal minCost, BigDecimal maxCost)
    {
        productFactory.PRODUCTS.stream()
                .filter(p -> p.getCost().compareTo(minCost) >= 0) // p.getCost() > minCost
                .filter(p -> p.getCost().compareTo(maxCost) <= 0) // p.getCost() < maxCost
                .forEach(Console::writeLine);
    }

    private static void getBetweenCost(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(
                            pf -> dataExistCallback(pf, new BigDecimal(args[1]), new BigDecimal(args[2])),
                            () -> Console.Error.writeLine("Data not exist!...")
                    );
        } catch (NumberFormatException ignore) {
            Console.Error.writeLine("Stock value must be an integer number!...");
        } catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        } catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // 4. Aşağıdaki demo örnekte komut satırından alınan minDate ve maxDate değerlerine göre (minDate, maxDate) aralığında doğan çalışanlar listelenmiştir
    private static void getBetweenDates(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            var staffs = StaffFactory.loadFromTextFile(args[0]).getStaffAsArray();
            var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            var minDate = LocalDate.parse(args[1], formatter);
            var maxDate = LocalDate.parse(args[2], formatter);

            Arrays.stream(staffs)
                    .filter(s -> s.getBirthDate().isAfter(minDate))
                    .filter(s -> s.getBirthDate().isBefore(maxDate))
                    .forEach(Console::writeLine);
        }
        catch (DateTimeParseException ignore) {
            Console.Error.writeLine("Invalid date format");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }

    }

    // 5. Aşağıdaki demo örnekte komut satırından alınan minYear ve maxYear değerlerine göre [minYear, maxYear] aralığında doğan çalışanlar listelenmiştir
    private static void getBetweenYears(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            var staffs = StaffFactory.loadFromTextFile(args[0]).getStaffAsArray();
            var minYear = Integer.parseInt(args[1]);
            var maxYear = Integer.parseInt(args[2]);

            Arrays.stream(staffs)
                    .filter(s -> minYear <= s.getBirthDate().getYear())
                    .filter(s -> s.getBirthDate().getYear() <= maxYear)
                    .forEach(Console::writeLine);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Year values must be numeric");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // 6. Aşağıdaki demo örnekte komut satırından alınan SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY biçimindeki yazılardan biri şeklinde alınan haftanın günü bilgisine göre ilgili günde izni olan çalışanlar listelenmektedir
    private static void getStaffsOnLeave(String [] args)
    {

        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var staffs = StaffFactory.loadFromTextFile(args[0]).getStaffAsArray();
            var restWeekDay = DayOfWeek.valueOf(args[1].trim().toUpperCase());

            Arrays.stream(staffs)
                    .filter(s -> s.getRestDay() == restWeekDay)
                    .forEach(Console::writeLine);
        }
        catch (IllegalArgumentException ignore) {
            Console.Error.writeLine("Invalid weekday format");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // 7. Aşağıdaki demo örnekte komut satırından alınan SUN, MON, TUE, WED, THU, FRI, SAT biçimindeki yazılardan
    // biri şeklinde alınan haftanın günü bilgisine göre ilgili günde izni olan çalışanlar listelenmektedir.
    // Örnekte alınan değerlerin geçerliliği kontrol edilmektedir. Değerler yalnızca belirtildiği gibi alınabilmektedir.
    private static void getStaffsOnLeaveWithShortcut(String [] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var staffs = StaffFactory.loadFromTextFile(args[0]).getStaffAsArray();
            var restWeekDay = args[1].trim().toUpperCase();

            if (restWeekDay.length() != 3)
                return;

            Arrays.stream(staffs)
                    .filter(s -> s.getRestDay().toString().startsWith(restWeekDay))
                    .forEach(Console::writeLine);
        }
        catch (IllegalArgumentException ignore) {
            Console.Error.writeLine("Invalid weekday format");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }

    }



}
