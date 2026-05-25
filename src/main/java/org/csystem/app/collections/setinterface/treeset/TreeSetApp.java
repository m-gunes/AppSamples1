package org.csystem.app.collections.setinterface.treeset;

import com.karandev.io.util.console.Console;
import org.csystem.math.Complex;
import org.csystem.math.Fraction;
import org.csystem.math.util.RandomComplexFactory;
import org.csystem.math.util.RandomFractionFactory;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.ToDoubleFunction;

public class TreeSetApp {
    public static void run()
    {
        naturalOrder();
    }

    // Örnekte Complex sınıfı Comparable arayüzünü desteklemediği için yani mutually comparable olmadığı için ClassCastException oluşur
    private static void complexNotComparable()
    {
        var treeSet = new TreeSet<Complex>();
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.createRandom(-5,5);
            Console.write("%s ", z);

            if (z.getNorm() > 5)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    private static void complexWithComparator()
    {
        // iki tane complex sayi gelecek,
        var treeSet = new TreeSet<Complex>((z1, z2) -> Double.compare(z1.getNorm(), z2.getNorm()));
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.createRandom(-5,5);
            Console.write("%s ", z);

            if (z.getNorm() > 5)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    // azalan
    private static void complexWithComparatorDesc()
    {
        // iki tane complex sayi gelecek,
        var treeSet = new TreeSet<Complex>((z1, z2) -> Double.compare(z2.getNorm(), z1.getNorm()));
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.createRandom(-5,5);
            Console.write("%s ", z);

            if (z.getNorm() > 5)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    private static void complexWithComparatorComparingDouble()
    {
        var treeSet = new TreeSet<Complex>(Comparator.comparingDouble(Complex::getNorm));
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.createRandom(-5,5);
            Console.write("%s ", z);

            if (z.getNorm() > 5)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    public static <T> Comparator<T> myComparingDouble(ToDoubleFunction<? super T> keyExtractor)
    {
        return (c1, c2) -> Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
    }

    private static void comparableFraction()
    {
        var treeSet = new TreeSet<Fraction>();
        var factory = new RandomFractionFactory(new Random());

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    // azalan

    private static void comparableFractionDesc()
    {
        var treeSet = new TreeSet<Fraction>((f1, f2) -> f2.compareTo(f1));
        var factory = new RandomFractionFactory(new Random());

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    // comparable bir tur icin ters sirada cagiriyor demek
    private static void comparableFractionReverseOrder()
    {
        var treeSet = new TreeSet<Fraction>(Comparator.reverseOrder());
        var factory = new RandomFractionFactory(new Random());

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    public static <T extends Comparable<T>> Comparator<T> myReverseOrder()
    {
        return (t1, t2) -> t2.compareTo(t1);
    }

    // TreeSet sınıfının Comparable arayüzü kullanılarak elemanları sıralayan ctor'ları ile nesne yaratıldığında null değer eklenmesi durumunda exception oluşur.
    private static void nullValue()
    {
        var treeSet = new TreeSet<Fraction>();
        var random = new Random();
        var factory = new RandomFractionFactory(random);

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            treeSet.add(random.nextBoolean() ? z : null);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    // Aşağıdaki demo örnekte null değeri başta olacak şekilde sıralama yapılmıştır. Örnekte Comparatorarayüzünün nullsFirst metodunun kullanıldığına dikkat ediniz
    public static void nullsfirst()
    {
        // var treeSet = new TreeSet<Fraction>(Comparator.nullsFirst((z1, z2) -> z1.compareTo(z2)));
        var treeSet = new TreeSet<>(Comparator.nullsFirst(Fraction::compareTo));
        var random = new Random();
        var factory = new RandomFractionFactory(random);

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            var isNotNull = random.nextBoolean();

            if (!isNotNull)
                Console.write("Null ");

            treeSet.add(isNotNull ? z : null);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    // Aşağıdaki demo örnekte null değeri sonda olacak şekilde sıralama yapılmıştır. Örnekte Comparatorarayüzünün nullsLast metodunun kullanıldığına dikkat ediniz
    public static void nullsLast()
    {
        // var treeSet = new TreeSet<Fraction>(Comparator.nullsLast((z1, z2) -> z1.compareTo(z2)));
        var treeSet = new TreeSet<>(Comparator.nullsLast(Fraction::compareTo));
        var random = new Random();
        var factory = new RandomFractionFactory(random);

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            var isNotNull = random.nextBoolean();

            if (!isNotNull)
                Console.write("Null ");

            treeSet.add(isNotNull ? z : null);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    public static void nullsLastWithReverseOrder()
    {
        var treeSet = new TreeSet<Fraction>(Comparator.nullsLast(Comparator.reverseOrder()));
        var random = new Random();
        var factory = new RandomFractionFactory(random);

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            var isNotNull = random.nextBoolean();

            if (!isNotNull)
                Console.write("Null ");

            treeSet.add(isNotNull ? z : null);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

    // Fraction::compareTo ile ayni
    public static void naturalOrder()
    {
        var treeSet = new TreeSet<Fraction>(Comparator.nullsLast(Comparator.naturalOrder()));
        var random = new Random();
        var factory = new RandomFractionFactory(random);

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            var isNotNull = random.nextBoolean();

            if (!isNotNull)
                Console.write("Null ");

            treeSet.add(isNotNull ? z : null);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }

}
