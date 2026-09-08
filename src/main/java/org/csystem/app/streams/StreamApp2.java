package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import org.apache.commons.lang3.math.NumberUtils;
import org.csystem.util.datasource.factory.NumberFactory;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.factory.StaffFactory;
import org.csystem.util.numeric.NumberUtil;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class StreamApp2 {
    public static void run(String[] args)
    {
//        anyMatchEx(args);
//        getStaffOnLeave(args);
//        getStaffOnLeaveWithPeek(args);
//        getSize();
//        getAbsentStaff(args);
//        printCountOfNonPrimeNumbers(args);
//        printHowManyProductsUntilTheProductHasNoStock(args);
//        printPrimeNumberUntilEnteredCount(args);
        printCountEnteredNumber();
    }

    // 1. Aşağıdaki örnekte stokta bulunmayan (stock <= 0) ürünün var olması ya da olmamasına göre uygun mesaj verilmiştir.
    private static void dataExistCallbackWithAnyMatch(ProductFactory productFactory)
    {
        if (productFactory.PRODUCTS.stream().anyMatch(p -> p.getStock() <= 0))
            Console.writeLine("At least one product is out of stock");
        else
            Console.writeLine("All products are in stock!");
    }

    private static void dataExistCallbackWithAllMatch(ProductFactory productFactory)
    {
        if (productFactory.PRODUCTS.stream().allMatch(p -> p.getStock() > 0))
            Console.writeLine("All products are in stock!");
        else
            Console.writeLine("At least one product is out of stock");
    }

    private static void dataExistCallbackWithNoneMatch(ProductFactory productFactory)
    {
        if (productFactory.PRODUCTS.stream().noneMatch(p -> p.getStock() <= 0))
            Console.writeLine("All products are in stock!");
        else
            Console.writeLine("At least one product is out of stock");
    }

    private static void anyMatchEx(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(StreamApp2::dataExistCallbackWithAnyMatch, () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    /*
        Aşağıdaki demo örnekte komut satırından alınan SUN, MON, TUE, WED, THU, FRI, SAT biçimindeki
      yazılardan biri şeklinde alınan haftanın günü bilgisine göre ilgili günde izni olan çalışanlar listelenmektedir.
      Örnekte alınan değerlerin geçerliliği kontrol edilmektedir. Değerler yalnızca belirtildiği gibi alınabilmektedir.
     */
    private static void getStaffOnLeave(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var dayOfWeekStream = Arrays.stream(DayOfWeek.values());

            if (args[1].length() == 3 && dayOfWeekStream.anyMatch(d -> d.toString().contains(args[1]))) {
                var factory = StaffFactory.loadFromTextFile(args[0]);
                var staffs = factory.getStaffAsArray();

                Arrays.stream(staffs)
                        .filter(s -> s.getRestDay().toString().startsWith(args[1]))
                        .forEach(Console::writeLine);
            }
            else
                Console.writeLine("Wrong rest day");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    private static void getStaffOnLeaveWithPeek(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var dayOfWeekStream = Arrays.stream(DayOfWeek.values());

            if (args[1].length() == 3 && dayOfWeekStream.peek(Console::writeLine).anyMatch(d -> d.toString().contains(args[1]))) {
                var factory = StaffFactory.loadFromTextFile(args[0]);
                var staffs = factory.getStaffAsArray();

                Arrays.stream(staffs)
                        .filter(s -> s.getRestDay().toString().startsWith(args[1]))
                        .forEach(Console::writeLine);
            }
            else
                Console.writeLine("Wrong rest day");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // count metodu ilgili değeri, stream'e ilişkin kaynağın durumuna göre efektif bir şekilde alma eğilimindedir.
    // Örneğin, stream'in kaynağında bu bilgi tutuluyorsa (List, dizi vb) ilgili pipeline'da bu bilgiyi doğrudan elde edebilir.
    // Bu durum implementasyona bağlıdır. Dokümanlarda da bu durum belirtilmiştir.
    // Bu işleme göre aşağıdaki örnekte peek metoduna ilişkin callback hiç çağrılmayabilir
    private static void getSize()
    {
        List<String> l = Arrays.asList("A", "B", "C", "D");
        long count = l.stream().peek(System.out::println).count();
        System.out.println(count);
        // bunun ekran ciktisi ne olur?
        // Cevap: implementasyona gore peek hic calismayabilir.
        // Calisirsa harfleri print eder ve count 4 olur. Calismazsa sadece 4 goruruz.
    }

    private static void getAbsentStaff(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var dayOfWeekStream = Arrays.stream(DayOfWeek.values());

            if (args[1].length() == 3 && dayOfWeekStream.anyMatch(d -> d.toString().contains(args[1]))) {
                var factory = StaffFactory.loadFromTextFile(args[0]);
                var staffs = factory.getStaffAsArray();

                var count = Arrays.stream(staffs)
                        .filter(s -> s.getRestDay().toString().startsWith(args[1]))
                        .count();

                Console.writeLine("Absent people count:%s", count);
            }
            else
                Console.writeLine("Wrong rest day");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte int türden bir dizi içerisindeki ilk asal sayıya kadar olan sayıların kaç tane olduğu bilgisi elde edilmiştir
    private static void printCountOfNonPrimeNumbers(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var numberFactory = NumberFactory.loadFromTextFile(args[0]);
            var numbers = numberFactory.getNumbers();

            var count = Arrays.stream(numbers)
                    .takeWhile(n -> !NumberUtil.isPrime(n))
                    .count();

            Console.writeLine("Non prime numbers count:%s", count);
        } catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        } catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte stokta bulunmayan ilk ürüne kadar kaç tane ürün olduğu bilgisi elde edilmiştir
    private static void dataExistCallback(ProductFactory productFactory)
    {
        var count = productFactory.PRODUCTS.stream().takeWhile(p -> p.getStock() > 0).count();
        Console.writeLine("Data exist callback count:%s", count);

    }
    private static void printHowManyProductsUntilTheProductHasNoStock(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var productFactory = ProductFactory.loadFromTextFile(args[0]);
            productFactory.ifPresentOrElse(StreamApp2::dataExistCallback, () -> Console.Error.writeLine("Data not exist!..."));

        } catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte komut satırından int türden alınan sayı kadar int türden asal sayı üretilmektedir
    private static void printPrimeNumberUntilEnteredCount(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var count = Integer.parseInt(args[0]);
            var random = new Random();
            IntStream.generate(random::nextInt).filter(NumberUtil::isPrime).limit(count).forEach(Console::writeLine);
        }
        catch (NumberFormatException e) {
            Console.Error.writeLine("Invalid count value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte klavyeden sıfır girilene kadar alınan pozitif sayıların kaç tane olduğu bilgisi elde edilmiştir
    private static void printCountEnteredNumber()
    {
        var count = IntStream.generate(() -> Console.readInt("input a number:"))
                .takeWhile(n -> n != 0)
                .filter(n -> n > 0)
                .count();
        Console.writeLine("Number entered count:%s", count);
    }

}
