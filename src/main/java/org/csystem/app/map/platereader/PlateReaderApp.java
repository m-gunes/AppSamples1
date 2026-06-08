package org.csystem.app.map.platereader;

import com.karandev.io.util.console.Console;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 Simulates a camera that reads plate numbers and stores car information whenever a car passes.
 */
public class PlateReaderApp {
    private static void carInfoListCallback(String plate, ArrayList<CarInfo> carInfoList)
    {
        Console.write("%s ", plate);
        carInfoList.forEach(c -> Console.write("%s, ", c.getDate()));
        Console.writeLine();
    }

    private static void runWithTreeMap()
    {
        TreeMap<String, ArrayList<CarInfo>> carMap = new TreeMap<>();
        while (true) {
            String plate = Console.read("input plate: ");

            if (plate.equals("exit"))
                break;

            if (carMap.containsKey(plate)) {
                carMap.get(plate).add(CarInfo.builder().plate(plate).date(LocalDateTime.now()).build());
            } else {
               ArrayList<CarInfo> list = new ArrayList<>();
               list.add(CarInfo.builder().plate(plate).date(LocalDateTime.now()).build());
               carMap.put(plate, list);
            }
        }

        carMap.keySet().forEach(p -> carInfoListCallback(p, carMap.get(p)));
    }

    private static void runWithHashMap()
    {
        HashMap<String, ArrayList<CarInfo>> carMap = new HashMap<>();
        while (true) {
            String plate = Console.read("input plate: ");

            if (plate.equals("exit"))
                break;

            if (carMap.containsKey(plate)) {
                carMap.get(plate).add(CarInfo.builder().plate(plate).date(LocalDateTime.now()).build());
            } else {
                ArrayList<CarInfo> list = new ArrayList<>();
                list.add(CarInfo.builder().plate(plate).date(LocalDateTime.now()).build());
                carMap.put(plate, list);
            }
        }

        carMap.keySet().forEach(p -> carInfoListCallback(p, carMap.get(p)));
    }
    public static void run()
    {
        runWithHashMap();
    }
}



@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
class CarInfo {
    private String m_plate;
    private LocalDateTime m_date;
}
