package org.csystem.app.streams;

import com.karandev.io.util.console.Console;

import java.util.Set;
import java.util.stream.Stream;

public class OrderedAndUnordered {
    // Aşağıdaki örnekte elemanların öncelik sonralık ilişkisinin ara işlemler boyunca değişmeyeceği garanti altındadır
    public static void ordered()
    {
        Stream.of(10, 20, 41, 8, 11, 6).filter(v -> v % 2 == 0).forEach(v -> Console.write("%d ", v));
    }


    // Aşağıdaki örnekte elemanların öncelik sonralık ilişkisinin ara işlemler boyunca değişmeyeceği garanti altında değildir
    public static void unordered()
    {
        Set.of(10, 20, 41, 8, 11, 6).stream().filter(v -> v % 2 == 0).forEach(v -> Console.write("%d ", v));

        Console.writeLine();

        Stream.of(10, 20, 41, 8, 11, 6).unordered().filter(v -> v % 2 == 0).forEach(v -> Console.write("%d ", v));
    }

    public static void run(String[] args)
    {
        unordered();
    }
}
