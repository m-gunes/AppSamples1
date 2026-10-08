package org.csystem.app.streams.files;


import com.karandev.io.util.console.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;


public class AppendRandomBytesApp {
    private static void addBytesCallback2(Random r, FileOutputStream fos)
    {
        try {
            byte v = (byte) r.nextInt(-128, 128);
            Console.write("%d ", v);
            fos.write(v);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred while adding random byte:%s", e.getMessage());
        }
    }


    private static void writeFile(String path, int count)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            Random r = new Random();

            for (int i = 0; i < count; ++i) {
                byte v = (byte)r.nextInt(-128, 128);

                Console.write("%d ", v);
                fos.write(v);
            }

            Console.writeLine();
        }
        catch (FileNotFoundException ignore) {
            Console.Error.writeLine("Error occurred while creating file:%s", path);
        } catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static void writeFile2(String path, int count)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            Random r = new Random();
            IntStream.range(0, count).forEach(i -> addBytesCallback2(r, fos));
            Console.writeLine();
        }
        catch (FileNotFoundException ignore) {
            Console.Error.writeLine("Error occurred while creating file:%s", path);
        } catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            int count = Integer.parseInt(args[1]);

            if (count < 1)
                throw new NumberFormatException();

            writeFile(args[0], count);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Count must be a positive integer");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

}
