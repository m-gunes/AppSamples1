package org.csystem.app.collections.iterator;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.generator.random.RandomIntGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


@Slf4j
public class IteratorApp {
    public static void run()
    {
        forEachRemainingEx();
    }

    private static void forEachRemainingEx()
    {
        var texts = new ArrayList<String>();
        while (true) {
            var s = Console.read("input text:");
            if ("quit".equals(s))
                break;

            texts.add(s);
        }

        Iterator<String> iter = texts.iterator();
        iter.next(); // iterator'u bir ilerletiyoruz ve forEachRemaining kalinan yerden basliyor.
        iter.forEachRemaining(log::info);
    }

    private static void randomIntGenerator()
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

    private static void arrayListEx()
    {
        var texts = new ArrayList<String>();

        while (true) {
            var s = Console.read("Input text:");

            if ("quit".equals(s))
                break;

            texts.add(s);
        }

        Iterator<String> iter = texts.iterator();

        while (iter.hasNext()) {
            String s = iter.next();
            log.info(s);
        }
    }
}
