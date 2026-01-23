package org.csystem.app.annotations;

import com.karandev.io.util.console.Console;

public class FunctionalInterfaceApp {
    public static void run()
    {
        IIntBinaryConsumer ic = (a, b) -> Console.writeLine("a = %d, b = %d",a,b);
    }
}


@FunctionalInterface
@Deprecated(forRemoval = true, since = "1.1.0")
interface IIntBinaryConsumer {
    void accept(int a, int b);
    default void accept(Integer a, Integer b)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}