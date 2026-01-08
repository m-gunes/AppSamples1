package org.csystem.app.innerclasses;

import com.karandev.io.util.console.Console;

public class MemoryLeakSample {
    public static void run()
    {
        while (true) {
            var c = new C();
            c.foo();

            //..
        }
    }
}


class C {
    private D m_b;

    public void foo()
    {
        Console.writeLine("C.foo");
        m_b = new D();
        m_b.bar();
//        m_b = null; // solution
    }

    public class D {
        public void bar()
        {
            Console.writeLine("D.bar");
        }
    }
}


