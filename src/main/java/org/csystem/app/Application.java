package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.app.studycase.scheduler.timeout.CountDownScheduler;
import org.csystem.app.time.TimeUnitSamples;

import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String[] args)
    {
        CountDownScheduler countDown = new CountDownScheduler(10000, 1000){
//        CountDownScheduler countDown = new CountDownScheduler(10, 1, TimeUnit.SECONDS){
            public void onTick(long remainingMilliseconds)
            {
                Console.writeLine((10000 - remainingMilliseconds));
            }
            public void onFinish()
            {
                Console.writeLine("Finito");
            }
        };

        countDown.start();
    }
}



class A implements IX {
}

abstract class B implements IX { //error
//...
}
 class C implements IX, IY {
    public void foo()
    {
//...
    }
    public void bar()
    {
//...
    }

     @Override
     public void tar()
     {

     }
 }

class D implements IX, IY {
    public void foo()
    {
//...
    }
    public void bar()
    {
//...
    }
    public void tar()
    {
//...
    }
}
interface IX {
    void foo();
}
interface IY {
    void bar();
    void tar();
}