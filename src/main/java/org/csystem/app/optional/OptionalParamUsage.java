package org.csystem.app.optional;

import com.karandev.io.util.console.Console;
import org.csystem.math.geometry.Point;

import java.time.LocalDate;
import java.util.Optional;

public class OptionalParamUsage {
    public static void run()
    {
        var p1 = Point.createCartesian(100, 100);
        var p2 = Point.createCartesian(200, 300);

//        optionalParamEx(p1, p2);
        withoutOptionalParamEx(p1, p2);
    }

    private static void optionalParamEx(Point p1, Point p2)
    {
        Util1.write(p1, Optional.of(LocalDate.now()));
        Util1.write(p2, Optional.empty());
    }

    private static void withoutOptionalParamEx(Point p1, Point p2)
    {
        Util2.write(p1, LocalDate.now());
        Util2.write(p2);
    }
}

class Util1 {
    // Optional bir sınıf türden değişken metot parametre değişkeni olarak kullanılabilse de pratikte çok çok kullanışlı değildir.
    public static void write(Point p, Optional<LocalDate> dateOpt)
    {
        if (dateOpt.isPresent())
            Console.writeLine("Point:%s, Date:%s", p, dateOpt.get());
        else
            Console.writeLine("Point:%s", p);
    }
}

// write metodu overload edilerek de aynı işlem yapılabilir. Recommended!
class Util2 {
    public static void write(Point p)
    {
        Console.writeLine("Point:%s", p);
    }

    public static void write(Point p, LocalDate dateOpt)
    {
        Console.writeLine("Point:%s, Date:%s", p, dateOpt);
    }
}
