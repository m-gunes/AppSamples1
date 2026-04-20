package org.csystem.app.variance;

import java.util.ArrayList;

public class Covariance {
    public static void run()
    {
        X<B> xb = new X<>();
        // X<A> xa = xb; Error
        X<? extends A> xa = xb;

        xb.foo(new B());
//        xa.foo(new A()); // Error

    }
    private static void validImplicitConversion()
    {
        ArrayList<Integer> integers = new ArrayList<>();

        ArrayList<? extends Number> numbers = integers; // covariant
        // read only kabul ediliyor. ekleme yapilamiyor
//        numbers.add(3); // Error

        // ama get, read yapilabiliyor
        numbers.get(0);
        for (var n : numbers)
            System.out.println(n);

    }
}


class A {
    //..
}

class B extends A {
    //..
}

class X<T> {
    public void foo(T t)
    {
        //..
    }
}
