package org.csystem.app.collections.iterator;

import com.karandev.io.util.console.Console;
import org.csystem.generator.random.RandomIntGenerator;

import java.util.Random;

public class IteratorApp {
    public static void run()
    {
        var generator = new RandomIntGenerator(new Random(), 5, 1, 100);

        var iter = generator.iterator();

        while (iter.hasNext()) {
            var val = iter.next();
            Console.write("%02d ", val);
        }

        Console.writeLine();

        iter = generator.iterator();

        while (iter.hasNext()) {
            var val = iter.next();
            Console.write("%02d ", val);
        }

    }
}
