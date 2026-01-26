package org.csystem.app.reflection;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.string.StringUtil;

import java.util.ArrayList;

@Slf4j
public class ReflectionApp {
    public static void run()
    {
        forName();
    }

    public static void classExpression()
    {
        var clsInt = int.class;
        var clsDouble = double.class;
        var clsString = String.class;
        var clsStringUtil = StringUtil.class;
        var clsIntArray = int[].class;
        var clsStringArray = String[].class;

        log.info("Name: {}", clsInt);
        log.info("Name: {}", clsDouble);
        log.info("Name: {}", clsString);
        log.info("Name: {}", clsStringUtil);
        log.info("Name: {}", clsIntArray);
        log.info("Name: {}", clsStringArray);
    }

    public static void forName()
    {
        while (true) {
            try {
                var clsName = Console.read("Input class name:");
                if ("exit".equals(clsName))
                    break;

                var clsRef = Class.forName(clsName);
                log.info("Name:{}", clsRef.getName());

                for (var m : clsRef.getDeclaredMethods())
                    log.info(m.getName());

            } catch (ClassNotFoundException e) {
                log.error("Class not found: {}", e.getException());
            }
        }
    }
}
