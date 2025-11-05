package org.csystem.app.big;

import com.karandev.io.util.console.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalSamples {
    public static void main(String[] args)
    {
        divideCompareTo();
    }

    public static void roundingErrors()
    {
        while (true) {
            var a = Console.readDouble("Input first number:");
            var b = Console.readDouble("Input second number:");
            var c = Console.readDouble("Input third number:");
            var d = a + b;

            Console.writeLine("a = %.20f", a);
            Console.writeLine("b = %.20f", b);
            Console.writeLine("c = %.20f", c);
            Console.writeLine("d = %.20f", d);

            if (c == d)
                break;
        }
    }

    public static void roundingErrorSolution()
    {
        while (true) {
            var a = Console.readDouble("Input first number:");
            var b = Console.readDouble("Input second number:");
            var c = Console.readDouble("Input third number:");
            var d = a + b;

            Console.writeLine("a = %.20f", a);
            Console.writeLine("b = %.20f", b);
            Console.writeLine("c = %.20f", c);
            Console.writeLine("d = %.20f", d);

            if (Math.abs(c - d) < 0.000001)
                break;
        }
    }

    public static void equal()
    {
        while (true) {
            var a = new BigDecimal(Console.read("Input first number:"));
            var b = new BigDecimal(Console.read("Input second number:"));
            var c = new BigDecimal(Console.read("Input third number:"));
            var d = a.add(b);

            Console.writeLine("a = %.200f", a);
            Console.writeLine("b = %.200f", b);
            Console.writeLine("c = %.200f", c);
            Console.writeLine("d = %.200f", d);

            if (c.equals(d))
                break;
        }
    }

    public static void divideError()
    {
        var a = Console.readBigDecimal("Input first number:");
        var b = Console.readBigDecimal("Input second number:");
        var c = a.divide(b);

        Console.writeLine("a = %.200f", a);
        Console.writeLine("b = %.200f", b);
        Console.writeLine("c = %.10f", c);
    }

    public static void divideRoundingMode()
    {
        var a = Console.readBigDecimal("Input first number:");
        var b = Console.readBigDecimal("Input second number:");
        var c = a.divide(b, 10, RoundingMode.HALF_UP);

        Console.writeLine("a = %.10f", a);
        Console.writeLine("b = %.10f", b);
        Console.writeLine("c = %.10f", c);
    }

    public static void divideSetScale()
    {
        var a = Console.readBigDecimal("Input first number:");
        var b = Console.readBigDecimal("Input second number:");
        a = a.setScale(20, RoundingMode.HALF_UP);

        var c = a.divide(b, RoundingMode.HALF_UP);

        Console.writeLine("a = %.20f", a);
        Console.writeLine("b = %.20f", b);
        Console.writeLine("c = %.21f", c);
    }
    public static void divideCompareTo()
    {
        var a = Console.readBigDecimal("Input first number:");
        var b = Console.readBigDecimal("Input second number:");

        Console.writeLine(a.compareTo(b));
    }
}
