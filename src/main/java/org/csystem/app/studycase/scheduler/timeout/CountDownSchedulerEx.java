package org.csystem.app.studycase.scheduler.timeout;

import java.util.concurrent.TimeUnit;


/**
 * Sınıf SchedulerLib içerisinde yazılacaktır
 * Sınıfın kullanımına ilişkin örnekleri inceleyiniz
 * Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz.
 *
 *
 * return new CountDownSchedulerX(TOTAL_SECONDS, PERIOD_IN_SECONDS, TimeUnit.SECONDS) {
 *     public void onStart()
 *     {
 *         //Geri sayım başlatıldığında bir kez çağrılacak
 *     }
 *
 *     public void onTick(long remainingMilliseconds)
 *     {
 *         //Her saniyede bir çağrılacak ve kalan zaman (milisaniye cinsinden) argüman olarak geçilmiş olacak
 *     }
 *
 *     public void onFinish()
 *     {
 *         //10 saniye sonunda yani geri sayım tamamlandığında çağrılacak
 *     }
 * }.startX();
 */

public abstract class CountDownSchedulerEx extends CountDownScheduler {

    protected CountDownSchedulerEx(long durationInFuture, long countDownInterval, TimeUnit timeUnit)
    {
        this(timeUnit.toMillis(durationInFuture), timeUnit.toMillis(countDownInterval));
    }

    protected CountDownSchedulerEx(long millisInFuture, long countDownInterval)
    {
        super(millisInFuture, countDownInterval);
    }

    public abstract void onStart();

    public void startX()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
