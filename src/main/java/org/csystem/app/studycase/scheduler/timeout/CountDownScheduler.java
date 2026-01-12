package org.csystem.app.studycase.scheduler.timeout;

import java.util.concurrent.TimeUnit;

/**
 * Sınıfın ctor'ları ilgili parametrelere göre geri sayımın her adımında onTick metodunu çağıracaktır.
 * Geri sayım tamamlandığında ise onFinish metodu çağrılacaktır. onTick metoduna kalan milisaniye sayısı argüman olarak geçilecektir.
 * Sınıfı Timer sınıfını kullanarak yazınız
 *
 * Sınıfı bir CountDownScheduler nesnesi ile yalnızca bir kez geri sayım yapacak şekilde yazınız.
 */
public abstract class CountDownScheduler {
    protected CountDownScheduler(long durationInFuture, long countDownInterval, TimeUnit timeUnit)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    protected CountDownScheduler(long millisInFuture, long countDownInterval)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public abstract void onTick(long remainingMilliseconds);
    public abstract void onFinish();

    public final void start()
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public final void cancel()
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
