package org.csystem.app.optional;


import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.generator.random.RandomIntGenerator;
import org.csystem.util.numeric.NumberUtil;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;

@Slf4j
public class OptionalApp {
    public static void run()
    {
        findFirstIntOrElseGet();
    }

    private static void findFirstIntIsPresent()
    {
       while (true) {
           var count = Console.readInt("count:");
           if (count <= 0)
               break;
           var origin = Console.readInt("origin:");
           var bound = Console.readInt("bound:");

           var generator = new RandomIntGenerator(new Random(), count, origin, bound);
           var optInt = generator.findFirst(NumberUtil::isPrime);

           if (optInt.isPresent())
               log.info("First prime number: {}", optInt.getAsInt());
           else
               log.info("Not any prime number generated");
       }
    }
    private static void findFirstIntIsEmpty()
    {
        while (true) {
            var count = Console.readInt("count:");
            if (count <= 0)
                break;
            var origin = Console.readInt("origin:");
            var bound = Console.readInt("bound:");

            var generator = new RandomIntGenerator(new Random(), count, origin, bound);
            var optInt = generator.findFirst(NumberUtil::isPrime);

            if (optInt.isEmpty())
                log.info("Not any prime number generated");
            else
                log.info("First prime number: {}", optInt.getAsInt());
        }
    }

    private static void findFirstIntIfPresentOrElse()
    {
        while (true) {
            var count = Console.readInt("count:");
            if (count <= 0)
                break;
            var origin = Console.readInt("origin:");
            var bound = Console.readInt("bound:");

            var generator = new RandomIntGenerator(new Random(), count, origin, bound);
            var optInt = generator.findFirst(NumberUtil::isPrime);

            optInt.ifPresentOrElse(v -> log.info("First prime number: {}", v), () -> log.info("Not any prime number generated"));
        }
    }

    private static void findFirstIntIfPresent()
    {
        while (true) {
            var count = Console.readInt("count:");
            if (count <= 0)
                break;
            var origin = Console.readInt("origin:");
            var bound = Console.readInt("bound:");

            var generator = new RandomIntGenerator(new Random(), count, origin, bound);
            var optInt = generator.findFirst(NumberUtil::isPrime);

            optInt.ifPresent(v -> log.info("First prime number: {}", v));
        }
    }

    private static void findFirstIntOrElse()
    {
        while (true) {
            var count = Console.readInt("count:");
            if (count <= 0)
                break;

            var generator = new RandomIntGenerator(new Random(), count, 1, 97);
            var optInt = generator.findFirst(NumberUtil::isPrime);

            // Optional sınıflarının orElse metodu optional dolu ise içerisindeki değeri, boş ise parametresi ile aldığı değeri döndürür.
            log.info("Value: {}", optInt.orElse(97));
        }
    }

    private static void findFirstIntOrElseThrow()
    {
        while (true) {
            try {
                var count = Console.readInt("count:");
                if (count <= 0)
                    break;

                var generator = new RandomIntGenerator(new Random(), count, 1, 97);
                var optInt = generator.findFirst(NumberUtil::isPrime);
                // orElseThrow metodunun parametresiz overload'u boş bir optional için NoSuchElementException fırlatır.
                log.info("First prime number: {}", optInt.orElseThrow());

            } catch (NoSuchElementException e) {
                log.info("Not any prime number generated: {}", e.getMessage());
            }
        }
    }

    private static void findFirstIntOrElseThrowWithParam()
    {
        while (true) {
            try {
                var count = Console.readInt("count:");
                if (count <= 0)
                    break;

                var generator = new RandomIntGenerator(new Random(), count, 1, 97);
                var optInt = generator.findFirst(NumberUtil::isPrime);
                // orElseThrow metodunun parametresiz overload'u boş bir optional için NoSuchElementException fırlatır.
                log.info("First prime number: {}", optInt.orElseThrow(InputMismatchException::new));

            } catch (InputMismatchException e) {
                log.info("Not any prime number generated");
            }
        }
    }

    private static void findFirstIntOrElseThrowWithParamV2()
    {
        while (true) {
            try {
                var count = Console.readInt("count:");
                if (count <= 0)
                    break;

                var generator = new RandomIntGenerator(new Random(), count, 1, 97);
                var optInt = generator.findFirst(NumberUtil::isPrime);
                // orElseThrow metodunun Supplier<? extends Throwable> parametreli overload'u ile istenilen bir exception sınıfının fırlatılması sağlanabilir.
                log.info("First prime number: {}", optInt.orElseThrow(() -> new InputMismatchException("Not any prime number generated")));

            } catch (InputMismatchException e) {
                log.info(e.getMessage());
            }
        }
    }

    private static void findFirstIntOrElseGet()
    {
        while (true) {
            var count = Console.readInt("count:");
            if (count <= 0)
                break;

            var generator = new RandomIntGenerator(new Random(), count, 1, 97);
            var optInt = generator.findFirst(NumberUtil::isPrime);

            // orElseGet metodu optional'ın boş olması durumunda değerin elde edileceği supplier'ı callback olarak alır.
            var value = optInt.orElseGet(() -> new Random().nextInt(200, 500));
            log.info("Value: {}", value);
        }
    }
}
