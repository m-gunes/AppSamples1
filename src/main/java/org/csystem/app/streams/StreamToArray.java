package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.utils.ObjectArrayGenerator;
import org.csystem.util.datasource.factory.NameFactory;

import java.io.IOException;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
public class StreamToArray {

    public static void toArrayException(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var names = NameFactory.loadFromTextFile(args[0]).NAMES;
            var namesArray = names.stream()
                    .filter(n -> n.contains(args[1]))
                    .toArray();

            String [] str = (String []) namesArray; //ClassCastException
            //...
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    public static void toArrayItemCast(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var names = NameFactory.loadFromTextFile(args[0]).NAMES;
            var namesArray = names.stream()
                    .filter(n -> n.contains(args[1]))
                    .toArray();

            Arrays.stream(namesArray)
                    .map(o -> ((String)o).toUpperCase())
                    .forEach(Console::writeLine);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    public static void toArrayIntFunction(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var names = NameFactory.loadFromTextFile(args[0]).NAMES;
            var namesArray = names.stream()
                    .filter(s -> s.contains(args[1]))
                    .toArray(String[]::new);

            Arrays.stream(namesArray)
                    .map(String::toUpperCase)
                    .forEach(Console::writeLine);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    public static void toArrayGeneratedTypes(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var generator = new ObjectArrayGenerator();

            Arrays.stream(generator.createObjectArray(n))
                    .peek(o -> log.info("Dynamic type:{}, Value:{}", o.getClass().getSimpleName(), o))
                    .filter(o -> o instanceof String)
                    .map(o -> ((String)o).toUpperCase())
                    .forEach(Console::writeLine);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    public static void run(String[] args)
    {
        toArrayGeneratedTypes(args);
    }
}

