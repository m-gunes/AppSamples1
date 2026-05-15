package org.csystem.app.collections.priorityqueue;


import com.karandev.io.util.console.Console;
import org.csystem.app.collections.device.DeviceData;
import org.csystem.app.collections.device.DeviceDataSource;
import org.csystem.scheduler.timeout.CountDownScheduler;

import java.util.PriorityQueue;

public class DeviceApp {
    public static void run()
    {
        var deviceDataSource = new DeviceDataSource();
        var priorityQueue = new PriorityQueue<DeviceData>((d1, d2) -> (int)d2.getData() - (int)d1.getData()); // bu lambda nasil calisiyor

        new CountDownScheduler(10, 1) {
            @Override
            public void onTick(long remainingMilliseconds)
            {
                var data = deviceDataSource.fetchDeviceData();
                Console.writeLine("%s", data);
                priorityQueue.offer(data);
            }

            @Override
            public void onFinish()
            {
                Console.writeLine('\n');
                while (!priorityQueue.isEmpty())
                    Console.writeLine("%s", priorityQueue.poll());

                Console.writeLine();
            }
        }.start();
    }
}
