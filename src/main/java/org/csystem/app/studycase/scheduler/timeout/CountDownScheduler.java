package org.csystem.app.studycase.scheduler.timeout;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Sınıfın ctor'ları ilgili parametrelere göre geri sayımın her adımında onTick metodunu çağıracaktır.
 * Geri sayım tamamlandığında ise onFinish metodu çağrılacaktır. onTick metoduna kalan milisaniye sayısı argüman olarak geçilecektir.
 * Sınıfı Timer sınıfını kullanarak yazınız
 * Sınıfı bir CountDownScheduler nesnesi ile yalnızca bir kez geri sayım yapacak şekilde yazınız.
 */
public abstract class CountDownScheduler {
    private final Timer m_timer;
    private long m_duration;
    private final long m_countDownInterval;

    private TimerTask createTimerTask()
    {
        return new TimerTask() {
            public void run()
            {
                if (m_duration == 0){
                    onFinish();
                    m_timer.cancel();
                    return;
                }

                m_duration -= m_countDownInterval;
                onTick(TimeUnit.SECONDS.convert(m_duration, TimeUnit.MILLISECONDS));
            }
        };
    }

    protected CountDownScheduler(long durationInFuture, long countDownInterval, TimeUnit timeUnit)
    {
        m_duration = TimeUnit.MILLISECONDS.convert(durationInFuture, timeUnit);
        m_countDownInterval = TimeUnit.MILLISECONDS.convert(countDownInterval, timeUnit);
        m_timer = new Timer();
    }

    public CountDownScheduler(long millisInFuture, long countDownInterval)
    {
        this(millisInFuture, countDownInterval, TimeUnit.MILLISECONDS);
    }

    public abstract void onTick(long remainingMilliseconds);
    public abstract void onFinish();

    public final void start()
    {
        m_timer.scheduleAtFixedRate(createTimerTask(), 0, m_countDownInterval);
    }

    public final void cancel()
    {
        m_timer.cancel();
    }
}
