package org.csystem.app.anonymousclasses;

import com.karandev.io.util.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalWatch {
    public static void run()
    {
        var timer = new Timer();
//        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm.ss");
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm.ss");


//        timer.scheduleAtFixedRate(LocalDateTimeDisplayUtil.createTask(format), 0, 1000);

        var task = new TimerTask(){
            public void run()
            {
                Console.writeLine("Timeout:%s", formatter.format(LocalDateTime.now()));
                timer.cancel();
            }
        };

        Console.writeLine("Now:%s", formatter.format(LocalDateTime.now()));

        // timeout! Timer sınıfının iki parametreli schedule metotları timeout işleminde kullanılır.
        timer.schedule(task, 5000);
    }
}


class LocalDateTimeDisplayUtil {
    public static TimerTask createTask(DateTimeFormatter formatter)
    {
        return new TimerTask() {
            public void run()
            {
                Console.write("%s\r", formatter.format(LocalDateTime.now()));
            }
        };
    }
}
