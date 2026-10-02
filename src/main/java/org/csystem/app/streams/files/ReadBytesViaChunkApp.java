package org.csystem.app.streams.files;


import com.karandev.io.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;


public class ReadBytesViaChunkApp {
    private static void readFile(String path, int chunkSize)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte [] buf = new byte[chunkSize];
            int result;

            while ((result = fis.read(buf)) != -1) {
                for (int i = 0; i < result; i++)
                    Console.write("%d ", buf[i]);

                Console.write("%d ", buf[result - 1]);
            }
        }
        catch (FileNotFoundException ignore) {
            Console.Error.writeLine("Error occurred while opening file:%s", path);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static int readByteCallback(FileInputStream fis, byte [] buf)
    {
        int result = -1;

        try {
            result = fis.read(buf);
        }
        catch (IOException e) {
            Console.Error.writeLine("Error occurred while reading data");
        }

        return result;
    }

    private static void processByteCallback(int result, byte [] buf)
    {
        IntStream.range(0, result - 1)
                .mapToObj(i -> "%d, ".formatted(buf[i]))
                .forEach(Console::write);
        Console.write("%d:", buf[result - 1]);
    }

    private static void readFile2(String path, int chunkSize)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte [] buf = new byte[chunkSize];
            IntStream.generate(() -> readByteCallback(fis, buf)).takeWhile(r -> r != -1).forEach(r -> processByteCallback(r, buf));
            Console.writeLine();
        }
        catch (FileNotFoundException ignore) {
            Console.Error.writeLine("Error occurred while opening file:%s", path);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            int chunkSize = Integer.parseInt(args[1]);

            if (chunkSize <= 0)
                throw new NumberFormatException();

            readFile(args[0], chunkSize);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid chunk size");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}