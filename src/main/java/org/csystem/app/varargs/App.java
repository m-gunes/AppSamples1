package org.csystem.app.varargs;

import com.karandev.io.util.console.Console;
import org.csystem.Sample;

public class App {
    public static void run()
    {
        Util.printInts(10, 20, 30);
        Util.printInts(new int[]{10, 20, 30}); // derleyici bu kodu uretiyor

        Util.printInts(10, 20);
        Util.printInts(new int[]{10, 20}); // derleyici bu kodu uretiyor

        Util.printInts();
        Util.printInts(new int[]{}); // derleyici bu kodu uretiyor


        Util.printInts("Values", 10, 20, 30);


        Util.foo(10);
        Util.foo(10, 20);


        ///// Interview question
        Question.foo(10); // hangisi cagirilacak?
        // long parametreli secilir cunku temel turden.
        // eger foo(int a) olsaydi, o cagirilirdi.
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
    public static void foo(int a)
    {
        Console.writeLine("foo, int");
    }

    public static void foo(int...a)
    {
        Console.writeLine("foo, int...");
    }

//    public static void foo(int[] a) // Error: 'foo(int[])' is already defined
//    {
//        Console.writeLine("foo, int...");
//    }
}

class Question {

    public static void foo(long a)
    {
        Console.writeLine("foo, long");
    }

    public static void foo(int...a)
    {
        Console.writeLine("foo, int...");
    }
}
