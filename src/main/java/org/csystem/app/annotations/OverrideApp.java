package org.csystem.app.annotations;

import com.karandev.io.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

//App.jar -> uses XLib, ALib, BLib, CLib
public class OverrideApp {
    public static void run()
    {
        var factory = new XFactory();
        var random = new Random();
        while (true) {
            Console.writeLine("-----------------");
            var x = factory.create();
            Console.writeLine("Dynamic type: %s", x.getClass().getName());
            var a = random.nextInt(-10, 10);
            var b = random.nextInt(-10, 10);
            x.foo(a, b);
            Console.writeLine("-----------------");
            ThreadUtil.sleep(1000);
        }
    }
}

//Alib.jar uses XLib
class A extends X {
    @Override
    public void foo(int a, int b)
    {
        Console.writeLine("A -> a = %d, b = %d", a, b);
    }
}

//Blib.jar uses XLib
class B extends X {
    @Override
    public void foo(int a, int b)
    {
        Console.writeLine("B -> a = %d, b = %d", a, b);
    }
}

//Clib.jar uses XLib
class C extends X {
    @Override
    public void foo(int a, int b)
    {
        Console.writeLine("C -> a = %d, b = %d", a, b);
    }
}

//Xlib.jar
class XFactory {
    private final Random m_random = new Random();

    public X create()
    {
        return switch (m_random.nextInt(1, 4)) {
            case 1 -> new A();
            case 2 -> new B();
            default -> new C();
        };
    }
}

class X {
    public void foo(int a, int b) // if I changed as foo(int a, long b), it would give an error in @Override annotation where its defined. It will say; Method does not override method from its superclass
    {
        Console.writeLine("X -> a = %d, b = %d", a, b);
    }
}