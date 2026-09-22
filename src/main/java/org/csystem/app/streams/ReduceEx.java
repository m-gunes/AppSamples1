package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.ProductFactory;

import java.io.IOException;
import java.math.BigDecimal;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class ReduceEx {

    private static void dataExistCallback(ProductFactory productFactory)
    {
        var total = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > 0)
                .map(p -> p.getPrice().subtract(p.getCost()).multiply(BigDecimal.valueOf(p.getStock())))
//                .reduce((r, v) -> r.add(v));
//                .reduce(BigDecimal::add);
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Örnekte toplama işlemi sıfır değerinden başlatılmıştır

        Console.writeLine("Total:%s", total);
    }

    private static void reduceProfitLostRun(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(ReduceEx::dataExistCallback, () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    public static void run(String[] args)
    {
        reduceProfitLostRun(args);
    }
}
