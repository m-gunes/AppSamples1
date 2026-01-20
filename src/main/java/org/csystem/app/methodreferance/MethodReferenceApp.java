package org.csystem.app.methodreferance;

import com.karandev.io.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * Method Rerefence 4(dört) çeşittir:
 *
 * 1. static method reference.
 * 2. reference to an instance method of a particular object.
 * 3. reference to an instance method of any object of a particular type.
 * 4. constructor reference.
 */

public class MethodReferenceApp {
    public static void run()
    {
        RandomGenerator randomGenerator = new Random();

        IIntBinaryOperator ibo = Integer::sum; // 1. Lambda karsiligi: (a, b) -> Integer.sum(a, b);
        Console.writeLine(ibo.applyAsInt(10, 20));
        Console.writeLine("-------------------------");
        IIntUnaryPredicate iup = NumberUtil::isPrime; // 1. Lambda karsiligi: a -> NumberUtil.isPrime(a);
        Console.writeLine(iup.test(1_000_003));

        Console.writeLine("=========================");

        IIntSupplier is = randomGenerator::nextInt; // 2. Lambda karsiligi: () -> randomGenerator.nextInt();
        Console.writeLine(is.get());

        Console.writeLine("=========================");

        IIntRandomBoundSupplier irbs = RandomGenerator::nextInt;// 3. Lambda karsiligi: (r, b) -> r.nextInt(b);
        // public int nextInt(int bound) asagi seviyede nasil bir method?
        // Asagi seviyede su sekilde:
        // public static int nextInt(RandomGenerator randomGenerator, int bound)

        Console.writeLine(irbs.get(randomGenerator, 100));
        Console.writeLine("-------------------------");

        IStringToIntConverter sc = String::length; // 3. Lambda karsiligi: s -> s.length();
        Console.writeLine(sc.convert("mustafa"));

        Console.writeLine("=========================");

        IIntValueDefaultFactory ivdf = IntValue::new; // 4. Lambda karsiligi: () -> new IntValue();
        var intVal = ivdf.create();
        Console.writeLine(intVal.getValue());
        Console.writeLine("-------------------------");
        IIntValueFactory ivf = IntValue::new; // 4. Lambda karsiligi: a -> new IntValue(a);
        var intVal2 = ivf.create(3);
        Console.writeLine(intVal2.getValue());

        // callback vermek ve callback'in cagrilmasi seklinde bakiyoruz
        // IIntValueFactory ivf = IntValue::new;  => callback veriyoruz
        // var intVal2 = ivf.create(3); => callback'i cagiriyoruz
    }


}

class IntValue {
    private int m_value;

    public IntValue()
    {
    }

    public IntValue(int value)
    {
        m_value = value;
    }

    public int getValue()
    {
        return m_value;
    }
}


interface IStringToIntConverter {
    int convert(String str);
}

interface IIntValueFactory {
    IntValue create(int val);
}

interface IIntValueDefaultFactory {
    IntValue create();
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}

interface IIntUnaryPredicate {
    boolean test(int a);
}

interface IIntBinaryPredicate {
    boolean test(int a, int b);
}

interface IIntSupplier {
    int get();
}

interface IIntRandomBoundSupplier {
    int get(RandomGenerator randomGenerator, int bound);
}