package org.csystem.app.collections.arraydeque;

import com.karandev.io.util.console.Console;
import org.csystem.app.collections.device.DeviceData;
import org.csystem.app.collections.device.DeviceDataSource;

import java.util.ArrayDeque;

public class DeviceApp {
    public static void run()
    {
        var threshold = Console.readInt("Input threshold:");
        var arrayDeque = new ArrayDeque<DeviceData>();
        var dataSource = new DeviceDataSource();

        while (true) {
            var name = Console.read("Input name:");
            if ("quit".equals(name))
                break;

            var device = dataSource.fetchIntDeviceData(name);
            if ((int)device.getData() < threshold)
                arrayDeque.addFirst(device);
            else
                arrayDeque.addLast(device);

            Console.writeLine("Device:%s", device);
        }

        Console.writeLine("All devices:");
        arrayDeque.forEach(Console::writeLine);
    }
}
