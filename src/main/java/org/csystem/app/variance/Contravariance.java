package org.csystem.app.variance;

import java.util.ArrayList;

public class Contravariance {
    public static void run()
    {
       X<A> xa = new X<>();
       // X<B> xb = xa; // Error
       X<? super B> xb = xa;
       xb.foo(new B());
    }

    private static void possibleImplicitConversion()
    {
        ArrayList<Number> numbers = new ArrayList<>();
        // ArrayList<Integer> integers = numbers; // Error
        ArrayList<? super Integer> integers = numbers;
        // Burada alttan sinir belirlemis oluyoruz. Integer'in taban turleri acilimlari yapilabilir.
    }
}
