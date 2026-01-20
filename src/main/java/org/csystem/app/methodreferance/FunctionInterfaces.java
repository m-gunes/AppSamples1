package org.csystem.app.methodreferance;

import com.karandev.io.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FunctionInterfaces {
    public static void run()
    {
        example3();
    }

    public static void example3() {
        var count = Console.readInt("Input count:");
        var origin = Console.readInt("Input origin:");
        var bound = Console.readInt("Input bound:");
        var random = new Random();

        IntStream.generate(() -> random.nextInt(origin, bound)).filter(NumberUtil::isPrime).limit(count).forEach(Console::writeLine);
    }

    public static void example2()
    {
        var count = Console.readInt("Input count:");
        var random = new Random();
        LongStream.generate(random::nextLong).filter(NumberUtil::isPrime).limit(count).forEach(Console::writeLine);
    }

    public static void example1()
    {
        var random = new Random();

        IntStream.generate(() -> random.nextInt(100)).filter(a -> a % 2 == 0).limit(10).forEach(a -> Console.write("%d ", a));

        Console.writeLine();
    }
}
