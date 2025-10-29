package org.csystem.app.varargs;

import com.karandev.io.util.console.Console;

public class App {
    public static void main(String[] args)
    {
        Util.printInts(10, 20, 30);
        Util.printInts(new int[]{10, 20, 30}); // derleyici bu kodu uretiyor

        Util.printInts(10, 20);
        Util.printInts(new int[]{10, 20}); // derleyici bu kodu uretiyor

        Util.printInts();
        Util.printInts(new int[]{}); // derleyici bu kodu uretiyor


        Util.printInts("Values", 10, 20, 30);
    }
}

class Util {
    public static void printInts(int...ints)
    {
        for (var a : ints)
            Console.write("%d ", a);

        Console.writeLine();
    }

    public static void printInts(String prompt, int...ints)
    {
        Console.write("%s:", prompt);

        for (var a : ints)
            Console.write("%d ", a);

        Console.writeLine();
    }

//    public static void printInts(int[]ints) // overload edilemiyorlar
//    {
//    }
}
