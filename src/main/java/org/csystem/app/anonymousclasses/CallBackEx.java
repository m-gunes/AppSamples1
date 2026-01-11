package org.csystem.app.anonymousclasses;

import com.karandev.io.util.console.Console;

public class CallBackEx {

    public static void run(String[] args)
    {
        var c = Console.readInt("Input a value");
        C x = new C() {
            public void foo()
            {
                Console.writeLine("Value: %d", c);
                for (var arg: args)
                    Console.writeLine(arg);
            }
        };

        Demo.doWork(x);

        AFactory factory = new AFactory();
        Demo.doWork(factory.createA(10, 20));
    }
}


class AFactory {
    public C createA(int a, int b)
    {
        return new C() {
            public void foo()
            {
                Console.writeLine("%d + %d = %d", a, b, a + b);
            }
        };
    }
}

class Demo {
    // Yapacağı işin detayını dışarıdan alan bu tarz metotlar için high order method ya da vip method gibi kavramlar kullanılır.
    public static void doWork(C c) // doWork metodu callback alan bir metottur
    {
        c.foo();
    }
}

abstract class C {
    public abstract void foo();
}