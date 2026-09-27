package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
public class IterateEx {
    private static void iterateWithTwoPramEx(String[] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments");
        var a = Integer.parseInt(args[0]); // seed
        var n = Integer.parseInt(args[1]); // n tane
        var s = Integer.parseInt(args[2]); // step

        var result = IntStream.iterate(a, i -> i + s)
                .peek(v -> log.info("value:{}", v))
                .limit(n).sum();
        Console.writeLine("result:%d", result);
    }

    // Aşağıdaki örnekte stdin'den girilen int türden bir sayının asal olup olmadığı belirlenmiş ve uygun mesajlar verilmiştir
    private static void primeNumbers() // not so effective
    {
        var a = Console.readInt("Input a number");
        if(a < 1 && IntStream.iterate(2, v -> v <= a / 2, i -> i + 1).allMatch(v -> a % v != 0) )
            Console.writeLine("%d is a prime number", a);
        else
            Console.writeLine("%d is not a prime number", a);

       Console.writeLine();
    }
    // Aşağıdaki örnekte komut satırından alınan int türden bir sayının factorial değeri BigInteger türden elde edilmiştir. Örneğin iterate metodu ile yapılmıştır. Şüphesiz rangeClosed metodu ile yapılması daha yalındır
    private static void bigIntFactorial(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var result = IntStream.iterate(2, i -> i <= n, i -> i + 1) // rangeClosed(2,n)
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, BigInteger::multiply);

            Console.writeLine("%d! = %s", n, result);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    public static void run(String[] args)
    {
        log.info("{}", NumberUtil.isPrime(2));
        log.info("{}", NumberUtil.isPrime(1_000_003));
    }
}


class NumberUtil
{
    public static boolean isPrime(long a)
    {

        if (a <= 1)
            return false;

        if (a % 2 == 0)
            return a == 2;

        if (a % 3 == 0)
            return a == 3;

        if (a % 5 == 0)
            return a == 5;

        if (a % 7 == 0)
            return a == 7;

        return LongStream.iterate(11, i -> i * i <= a, i -> i + 2)
//                .noneMatch(i -> a % i == 0);
                .allMatch(i -> a % i != 0);

//        for (long i = 11; i * i <= a; i += 2)
//            if (a % i == 0)
//                return false;


    }
}
