package org.csystem.app.reflection;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.string.StringUtil;

import java.lang.reflect.InvocationTargetException;


@Slf4j
public class ReflectionApp {
    public static void run()
    {
        getDeclaredXXX();
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

    public static void getDeclaredMethods()
    {
        testSingletonLazy();
        var cls = SingletonLazy.class;
        var clsMethods = cls.getDeclaredMethods();

        for (var m : clsMethods)
            log.info("Method name: {}", m.getName());
    }

    private static void testSingletonLazy()
    {
        var s1 = SingletonLazy.getInstance();
        var s2 = SingletonLazy.getInstance();
        log.info("s1 == s2 -> {}", s1 == s2);
    }

    public static void getDeclaredX()
    {
        try {
            var cls = SingletonLazy.class;
            var ctor = cls.getDeclaredConstructor(int.class);
            ctor.setAccessible(true);

            var s = ctor.newInstance(10);
            log.info("Value: {}", s.getValue());

            ctor.setAccessible(false); // runtime optimization saglar. Bu ornekte gerekmesede, eger akisimiz devam etseydi, daha sonra yapilabilecek belli hatalardan dolayi, isimiz bittikten sonra false 'a cekmek gerekir.

        } catch(NoSuchMethodException e) {
            log.error("NoSuchMethodException, message -> {}", e.getMessage());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            log.error("Exception occurred: {}, Message: {}", e.getClass().getSimpleName(), e.getMessage());
        }
    }

    public static void getDeclaredXX()
    {
        try {
            var cls = SingletonEager.class;
            var ctor = cls.getDeclaredConstructor();
            ctor.setAccessible(true);

            var s = ctor.newInstance();
            log.info("Value: {}", s.getValue());

            s.setValue(10);
            log.info("Value: {}", s.getValue());

        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException, message -> {}", e.getMessage());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            log.error("Exception occurred: {}, Message: {}", e.getClass().getSimpleName(), e.getMessage());
        }
    }
    public static void getDeclaredXXX()
    {
        // Aşağıdaki demo örnekte enum sınıfı kullanıldığından programcı reflection kullanarak bile nesne yaratamaz
        try {
            var cls = Singleton.class;
            var ctor = cls.getDeclaredConstructor();
            ctor.setAccessible(true);

            var s = ctor.newInstance();
            log.info("Value: {}", s.getValue());

            s.setValue(10);
            log.info("Value: {}", s.getValue());

        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException, message -> {}", e.getMessage());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            log.error("Exception occurred: {}, Message: {}", e.getClass().getSimpleName(), e.getMessage());
        }
    }
}


// lazy implementation
class SingletonLazy {
    private static SingletonLazy ms_instance;
    private int m_value;

    private SingletonLazy()
    {
    }

    private SingletonLazy(int value)
    {
        m_value = value;
    }

    public static SingletonLazy getInstance()
    {
        return getInstance(0);
    }

    public static SingletonLazy getInstance(int value)
    {
        if (ms_instance == null)
            ms_instance = new SingletonLazy(value);

        return ms_instance;
    }

    public void setValue(int value)
    {
        m_value = value;
    }

    public int getValue()
    {
        return m_value;
    }
}

class SingletonEager {
    public static final SingletonEager INSTANCE = new SingletonEager();
    private int m_value;

    private SingletonEager()
    {
    }

    public void setValue(int value)
    {
       m_value = value;
    }

    public int getValue()
    {
        return m_value;
    }
}


// eager
enum Singleton {
   INSTANCE;
   private int m_value;

   public void setValue(int value)
   {
       m_value = value;
   }

   public int getValue()
   {
       return m_value;
   }
}