package org.csystem.app.innerclasses;

import com.karandev.io.util.console.Console;

public class ThisExpression {
    public static void run()
    {
        var a = new A(10);
        var b = a.new B(); // Byte code -> new A$B(a)
        b.foo();
    }
}

class A {
    private int m_x;

    public A(int x)
    {
        m_x = x;
    }

    public void foo()
    {
        Console.writeLine("A.foo");
    }

    public class B {
        public void foo()
        {
            Console.writeLine("A.B.foo");
            A.this.foo(); // this expression
        }
    }
}
