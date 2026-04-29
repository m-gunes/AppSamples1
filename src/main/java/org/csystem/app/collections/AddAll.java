package org.csystem.app.collections;

import com.karandev.io.util.console.Console;

import java.util.ArrayList;
import java.util.TreeSet;

public class AddAll {
    public static void run()
    {
        var strList = new ArrayList<String>();
        var strSet = new TreeSet<String>();

        while (true) {
            var s = Console.read("Input text:");
            if ("quit".equals(s))
                break;

            strList.add(s);
        }

        Console.writeLine("String List:");
        strList.forEach(s -> Console.write("%s ", s));

        Console.writeLine();

        strSet.addAll(strList);
        Console.writeLine("String Set:");
        strSet.forEach(s -> Console.write("%s ",s));
    }
}
