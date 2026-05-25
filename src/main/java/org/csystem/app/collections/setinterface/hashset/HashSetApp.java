package org.csystem.app.collections.setinterface.hashset;

import com.karandev.io.util.console.Console;
import org.csystem.math.Complex;
import org.csystem.math.Fraction;
import org.csystem.math.util.RandomComplexFactory;
import org.csystem.math.util.RandomFractionFactory;

import java.util.HashSet;
import java.util.Random;

public class HashSetApp {
    public static void run()
    {
        hashSetComplex();
    }

    public static void hashSetFaction()
    {
        var treeSet = new HashSet<Fraction>();
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

    public static void hashSetComplex()
    {
        var treeSet = new HashSet<Complex>();
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.createRandom(-5, 5);
            Console.write("%s ", z);

            if (z.getNorm() > 5)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }
}
