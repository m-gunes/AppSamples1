package org.csystem.app.anonymousclasses;

import com.karandev.io.util.console.Console;

public class AnonymousApp {
    public static void run()
    {
        var  a = new A(){

        };
        var b = new B(){

        };
        var ix = new IX() {

        };

        Console.writeLine(a.getClass().getName());
        Console.writeLine(b.getClass().getName());
        Console.writeLine(ix.getClass().getName());
    }
}

class A {

}

abstract class B {

}

interface IX {

}