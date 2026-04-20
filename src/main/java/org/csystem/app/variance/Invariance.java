package org.csystem.app.variance;

import java.util.ArrayList;
import java.util.Objects;

public class Invariance {
    public static void run()
    {

    }

    private static void invalidImplicitConversion()
    {
        ArrayList<Integer> integers = new ArrayList<>();
//        ArrayList<Number> numbers = integers; // Error
        // buradaki implicit conversion'in yapilamamasina invariance denir.
        // Peki neden?
        // Generics konusunun hedefi compile time da guvenligi saglamak, tur kontrolu yapmak.
        // yani compile time da herhangi bir sekilde olasi problemleri runtime birakmadan engellemeye calismak.
        // Generics lerin temel konusu: compile time da type kontrolu.

        // Peki bu atama islemi yapilabilseydi ne olurdu?
//         numbers.add(3.4); // Double.valueOf(3.4)
//         numbers.add(34); // Integer.valueOf(34);
        // 3.4 ve 34 'u kutulayabilirdim. Yani Number'dan turemis olan her datayi atabilirdim.
        // Ve aslinda new ArrayList<Integer>() 'i gormesine ragmen, bu arrayList'te tutulamayacak.
        // Alirken Integer olarak alamayacagim verilerida eklebiliyor olurdum. Iste bu yuzden bu kabul edilmiyor
        // bu kabul edilmemeye invariance deniliyor. Sifat olarak soylersek, invariant deniyor.


//        ArrayList<Objects> numbers = integers; // Error
    }
}
