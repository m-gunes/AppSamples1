package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class RangeEx {

    // Aşağıdaki örnekte komut satırından alınan a ve b değerleri için [a, b) aralığındaki sayılar stdout'a gönderilmiştir
    private static void rangeEx(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var a = Integer.parseInt(args[0]);
            var b = Integer.parseInt(args[1]);

            IntStream.range(a, b).forEach(i -> Console.write("%d ", i));
            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid bound value(s)");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte komut satırından alınan a ve b değerleri için [a, b] aralığındaki sayılar stdout'a gönderilmiştir
    private static void rangeClosedEx(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var a = Integer.parseInt(args[0]);
            var b = Integer.parseInt(args[1]);

            IntStream.rangeClosed(a, b).forEach(i -> Console.write("%d ", i));
            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid bound value(s)");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte komut satırından alınan a ve b değerleri için [a, b] aralığındaki asal sayılar stdout'a gönderilmiştir
    private static void rangeClosedPrimeNumberEx(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var a = Integer.parseInt(args[0]);
            var b = Integer.parseInt(args[1]);

            IntStream.rangeClosed(a, b).filter(NumberUtil::isPrime).forEach(i -> Console.write("%d ", i));
            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid bound value(s)");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    private static void rangeASCII()
    {
        IntStream.range(0,26).map(i -> 'A' + i).forEach(cp -> Console.write("%c ", (char)cp));
        Console.writeLine();
        IntStream.range(0,26).map(i -> 'A' + i).forEach(cp -> Console.write("%d-%c, ", cp, cp));
        Console.writeLine();
        IntStream.range(0,26).map(i -> 'a' + i).forEach(cp -> Console.write("%c ", (char)cp));
        Console.writeLine();
        IntStream.range(0,26).map(i -> 'a' + i).forEach(cp -> Console.write("%d-%c, ", cp, cp));
        Console.writeLine();
    }

    private static void rangeClosedAscii()
    {
        IntStream.rangeClosed('A','Z').forEach(i -> Console.write("%c ", (char)i));
        Console.writeLine();
        IntStream.rangeClosed('a','z').forEach(i -> Console.write("%c ", (char)i));
        Console.writeLine();
    }

    private static void rangeUnicode()
    {
        IntStream.rangeClosed(0, 65536).forEach(i -> Console.write("%c ", (char)i));
    }

    // Aşağıdaki örnekte komut satırından alınan int türden bir sayının factorial değeri long türden elde edilmiştir
    private static void rangeClosedFactorial(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var result = LongStream.rangeClosed(2, n).reduce(1, (r, v) -> r * v);

            Console.writeLine("%d! = %d", n, result);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // Aşağıdaki örnekte komut satırından alınan int türden bir sayının factorial değeri BigInteger türden elde edilmiştir
    private static void rangeClosedBigIntegerFactorial(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var result = IntStream.rangeClosed(2, n)
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, BigInteger::multiply);

            Console.writeLine("%d! = %s", n, result);
        } catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value");
        } catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    public static void run(String[] args)
    {
        rangeClosedBigIntegerFactorial(args);
    }
}
