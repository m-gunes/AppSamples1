package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.numeric.NumberUtil;

import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
public class FindFirstAndFindAnyEx {
    // findFirst
    // Aşağıdaki örnekte stokta bulunmayan ilk ürün elde edilmektedir
    private static void findFirstDataExistCallback(ProductFactory productFactory)
    {
        var opt = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() <= 0)
                .findFirst();

        opt.ifPresentOrElse(
                p -> Console.writeLine("First product not in stock:%s", p),
                () -> Console.writeLine("All products are in stock")
        );
    }
    private static void findFirstRun(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(FindFirstAndFindAnyEx::findFirstDataExistCallback, () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte ilgili aralıkta ilk üretilen asal sayı elde edilmektedir.
    // Örnekte asal sayı üretilemezse sonsuz stream devam edecektir, dolayısıyla findFirst metodu geri dönmeyecektir.
    // Bu durumda ifPresentOrElse metodunun ikinci parametresine geçilen callable çağrılmayacaktır
    public static void findFirstPrimeNumber(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments");

        try {
            var a = Integer.parseInt(args[0]);
            var b = Integer.parseInt(args[1]);
            var random = new Random();

            var valueOpt = IntStream.generate(() -> random.nextInt(a, b))
                    .peek(v -> log.info("Generated value: {} ", v))
                    .filter(NumberUtil::isPrime)
                    .findFirst();

            valueOpt.ifPresentOrElse(p -> Console.writeLine("First generated prime number:%d", p), () -> Console.Error.writeLine("No prime number generated"));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte komut satırından satırından değer kadar üretilen sayılar içerisindeki ilk asal sayı elde edilmektedir.
    public static void findFirstPrimeNumberWithLimit(String[] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments");

        try {
            var n = Integer.parseInt(args[0]);
            var a = Integer.parseInt(args[1]);
            var b = Integer.parseInt(args[2]);
            var random = new Random();

            var valueOpt = IntStream.generate(() -> random.nextInt(a, b))
                    .peek(v -> log.info("Generated value: {} ", v))
                    .limit(n)
                    .filter(NumberUtil::isPrime)
                    .findFirst();

            valueOpt.ifPresentOrElse(p -> Console.writeLine("First generated prime number:%d", p), () -> Console.Error.writeLine("No prime number generated"));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte stokta bulunmayan herhangi bir ürün elde edilmektedir
    private static void findAnyDataCallback(ProductFactory productFactory)
    {
        var opt = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() <= 0)
                .findAny();

        opt.ifPresentOrElse(p -> Console.writeLine("First product not in stock:%s", p), () -> Console.writeLine("All products are in stock"));
    }
    private static void findAnyNotExistProduct(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(FindFirstAndFindAnyEx::findAnyDataCallback, () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte komut satırından satırından değer kadar üretilen sayılar içerisindeki herhangi bir asal sayı elde edilmektedir.
    public static void findAnyPrimeNumber(String[] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments");

        try {
            var n = Integer.parseInt(args[0]);
            var a = Integer.parseInt(args[1]);
            var b = Integer.parseInt(args[2]);
            var random = new Random();

            var valueOpt = IntStream.generate(() -> random.nextInt(a, b))
                    .peek(v -> log.info("Generated value: {} ", v))
                    .limit(n)
                    .filter(NumberUtil::isPrime)
                    .findAny();

            valueOpt.ifPresentOrElse(p -> Console.writeLine("First generated prime number:%d", p), () -> Console.Error.writeLine("No prime number generated"));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }

    }
    public static void run(String[] args)
    {
        findAnyPrimeNumber(args);
    }
}
