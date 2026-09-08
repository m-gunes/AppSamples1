package org.csystem.app.streams;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.factory.StaffFactory;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class StreamApp2 {
    public static void run(String[] args)
    {
//        anyMatchEx(args);
//        getStaffOnLeave(args);
//        getStaffOnLeaveWithPeek(args);
        getSize();
    }

    // 1. Aşağıdaki örnekte stokta bulunmayan (stock <= 0) ürünün var olması ya da olmamasına göre uygun mesaj verilmiştir.
    private static void dataExistCallbackWithAnyMatch(ProductFactory productFactory)
    {
        if (productFactory.PRODUCTS.stream().anyMatch(p -> p.getStock() <= 0))
            Console.writeLine("At least one product is out of stock");
        else
            Console.writeLine("All products are in stock!");
    }

    private static void dataExistCallbackWithAllMatch(ProductFactory productFactory)
    {
        if (productFactory.PRODUCTS.stream().allMatch(p -> p.getStock() > 0))
            Console.writeLine("All products are in stock!");
        else
            Console.writeLine("At least one product is out of stock");
    }

    private static void dataExistCallbackWithNoneMatch(ProductFactory productFactory)
    {
        if (productFactory.PRODUCTS.stream().noneMatch(p -> p.getStock() <= 0))
            Console.writeLine("All products are in stock!");
        else
            Console.writeLine("At least one product is out of stock");
    }

    private static void anyMatchEx(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(StreamApp2::dataExistCallbackWithAnyMatch, () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    /*
        Aşağıdaki demo örnekte komut satırından alınan SUN, MON, TUE, WED, THU, FRI, SAT biçimindeki
      yazılardan biri şeklinde alınan haftanın günü bilgisine göre ilgili günde izni olan çalışanlar listelenmektedir.
      Örnekte alınan değerlerin geçerliliği kontrol edilmektedir. Değerler yalnızca belirtildiği gibi alınabilmektedir.
     */
    private static void getStaffOnLeave(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var dayOfWeekStream = Arrays.stream(DayOfWeek.values());

            if (args[1].length() == 3 && dayOfWeekStream.anyMatch(d -> d.toString().contains(args[1]))) {
                var factory = StaffFactory.loadFromTextFile(args[0]);
                var staffs = factory.getStaffAsArray();

                Arrays.stream(staffs)
                        .filter(s -> s.getRestDay().toString().startsWith(args[1]))
                        .forEach(Console::writeLine);
            }
            else
                Console.writeLine("Wrong rest day");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    private static void getStaffOnLeaveWithPeek(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var dayOfWeekStream = Arrays.stream(DayOfWeek.values());

            if (args[1].length() == 3 && dayOfWeekStream.peek(Console::writeLine).anyMatch(d -> d.toString().contains(args[1]))) {
                var factory = StaffFactory.loadFromTextFile(args[0]);
                var staffs = factory.getStaffAsArray();

                Arrays.stream(staffs)
                        .filter(s -> s.getRestDay().toString().startsWith(args[1]))
                        .forEach(Console::writeLine);
            }
            else
                Console.writeLine("Wrong rest day");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }

    // count metodu ilgili değeri, stream'e ilişkin kaynağın durumuna göre efektif bir şekilde alma eğilimindedir.
    // Örneğin, stream'in kaynağında bu bilgi tutuluyorsa (List, dizi vb) ilgili pipeline'da bu bilgiyi doğrudan elde edebilir.
    // Bu durum implementasyona bağlıdır. Dokümanlarda da bu durum belirtilmiştir.
    // Bu işleme göre aşağıdaki örnekte peek metoduna ilişkin callback hiç çağrılmayabilir
    private static void getSize()
    {
        List<String> l = Arrays.asList("A", "B", "C", "D");
        long count = l.stream().peek(System.out::println).count();
        System.out.println(count);
    }
}
