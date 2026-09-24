package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.factory.StaffFactory;
import org.csystem.util.datasource.product.ProductInfo;
import org.csystem.util.datasource.staff.StaffInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
public class ReduceEx {

    // Aşağıdaki örnekte stokta bulunan ürünlere ilişkin total değer (kar-zarar durumu) elde edilmiştir.
    private static void totalCallback(ProductFactory productFactory)
    {
        var total = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > 0)
                .map(p -> p.getPrice().subtract(p.getCost()).multiply(BigDecimal.valueOf(p.getStock())))
//                .reduce((r, v) -> r.add(v));
//                .reduce(BigDecimal::add);
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Örnekte toplama işlemi sıfır değerinden başlatılmıştır

        Console.writeLine("Total:%s", total);
    }

    private static void reduceProfitLostRun(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(ReduceEx::totalCallback, () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }


    // Aşağıdaki örnekte stokta bulunan, birim fiyatı, komut satırından alınan minPrice ve maxPrice arasında kalan ürünlerin stok toplamı elde edilmiştir
    private static void totalStockCallback(ProductFactory productFactory, BigDecimal minPrice, BigDecimal maxPrice)
    {
        var totalStock = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > 0)
                .filter(p -> p.getPrice().compareTo(minPrice) >= 0)
                .filter(p -> p.getPrice().compareTo(maxPrice) <= 0)
                .peek(p -> log.info("{}", p))
                .mapToLong(ProductInfo::getStock)
//                .reduce((r, v) -> r + v)
//                .reduce(Long::sum)
                .sum();


         Console.writeLine("%s", totalStock > 0 ? "Total stock:%s".formatted(totalStock) : "There is no product in stock");
//        totalStockOpt.ifPresentOrElse(t -> Console.writeLine("Total stock:%s", t), () -> Console.writeLine("There is no product in stock"));
    }

    private static void totalStockRun(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(pf -> totalStockCallback(pf, new BigDecimal(args[1]), new BigDecimal(args[2])),
                            () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values for price(s)");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki demo örnekte komut satırından alınan n, a ve b değerleri için [a, b) aralığında üretilen
    // int türden n tane rassal sayının çarpımı elde edilmiştir
    private static void generateRandomInt(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");

            var n = Integer.parseInt(args[0]);
            var a = Integer.parseInt(args[1]);
            var b = Integer.parseInt(args[2]);

            var random = new Random();
            var result = LongStream.generate(() -> random.nextInt(a, b))
                    .limit(n)
                    .peek(i -> log.info("{}", i))
                    .reduce(1, (r,v) -> r * v);

            Console.writeLine("Result: %s", result);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values for price(s)");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }


    // Aşağıdaki örnekte komut satırından yyyy-MM-dd formatında alınan minDate ve maxDate değerleri için
    // (minDate, maxDate) aralığında bir tarihte işe girmiş olan çalışanların isimleri aralarında `,` olacak şekilde birleştirilmiştir
    private static void getEmployeeNamesBetweenDates(String[] args)
    {
       try {
           checkLengthEquals(args.length, 3, "Wrong number of arguments");
           var factory = StaffFactory.loadFromTextFile(args[0]);
           var staffs = factory.getStaffAsArray();
           var minDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_LOCAL_DATE);
           var maxDate = LocalDate.parse(args[2], DateTimeFormatter.ISO_LOCAL_DATE);

           var staffNamesOpt = Arrays.stream(staffs)
                   .filter(s -> s.getEntryDate().isAfter(minDate))
                   .filter(s -> s.getEntryDate().isBefore(maxDate))
                   .peek(s -> log.info("{}", s))
                   .map(StaffInfo::getName)
                   .reduce("%s, %s"::formatted);

           staffNamesOpt.ifPresentOrElse(str -> Console.writeLine("Names:%s", str), () -> Console.writeLine("No staff found"));

       } catch (IOException e) {
           Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
       }
       catch (Exception e) {
           Console.Error.writeLine("Error occurred :%s", e.getMessage());
       }
    }


    public static void run(String[] args)
    {
        getEmployeeNamesBetweenDates(args);
    }
}
