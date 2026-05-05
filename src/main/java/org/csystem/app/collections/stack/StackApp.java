package org.csystem.app.collections.stack;

import com.karandev.io.util.console.Console;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

public class StackApp {
    public static void run()
    {
        stackSearch();
    }

    private static void stackSearch()
    {
        var intStack = new Stack<Integer>();
        var random = new Random();
        while (true) {
            var val = random.nextInt(-10, 11);
            if (val == 0)
                break;
            var intVal = intStack.push(val);
            Console.writeLine(intVal);
        }

        var val = random.nextInt(-10, 11);
        Console.writeLine("%d will search", val);

        var order = intStack.search(val);
        Console.writeLine("%d %s", val, order != -1 ? "found at %d".formatted(order) : "not found");

        while (!intStack.empty()) {
            Console.write("%d ", intStack.pop());
        }


    }

    private static void stackLoopExceptionUsage() // bir baska stack dolasim sekli
    {

        var strStack = new Stack<String>();

        while (true) {
            var s = Console.read("Input text: ");

            if ("quit".equals(s))
                break;

            strStack.push(s);
        }

        // Stack'i dolasmak demek, ayni zamanda Stack'i bosaltmak demek.

        try {
            while (true) {
                var str = strStack.pop();
                Console.write("%s ", str);
            }
        } catch (EmptyStackException ignore) {
            Console.writeLine("...");
        }
    }

    private static void stackLoopUsage() // bir stack dolasim sekli
    {
        var strStack = new Stack<String>();

        while (true) {
            var s = Console.read("Input text: ");

            if ("quit".equals(s))
                break;

            strStack.push(s);
        }

        // Stack'i dolasmak demek, ayni zamanda Stack'i bosaltmak demek.

        while (!strStack.empty()) {
            var str = strStack.pop();
            Console.write("%s, ", str);
        }
    }

    private static void vectorLoopUsage()
    {
        var strStack = new Stack<String>();

        while (true) {
            var s = Console.read("Input text: ");

            if ("quit".equals(s))
                break;

            strStack.add(s);
        }

        strStack.forEach(Console::writeLine);
    }
}
