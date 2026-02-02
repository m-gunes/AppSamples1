package org.csystem.app.reflection;

import lombok.extern.slf4j.Slf4j;
import org.csystem.util.reflection.ReflectionUtil;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Slf4j
public class RepeatableAnnotation {
    private static void methodCallback(Method method)
    {
        var commands = method.getDeclaredAnnotationsByType(Command.class);
        if (commands.length != 0) {
            log.info("{} annotated with @Commend", method.getName());
            for (var command : commands)
                log.info("Value: {}", command.value());
        } else
            log.info("Not annotated with @Command");
    }

    public static void run()
    {
        var clsSample = Sample.class;

        log.info("All annotations:");
        for (Annotation annotation : clsSample.getDeclaredAnnotations())
            log.info(annotation.getClass().getTypeName());

        MyAnnotation [] myAnnotations = clsSample.getAnnotationsByType(MyAnnotation.class);
        log.info("My annotation status:");

        if (myAnnotations.length != 0)
            for (MyAnnotation myAnnotation: myAnnotations)
                log.info("Value: {}, Message: {}", myAnnotation.value(), myAnnotation.message());
        else
            log.info("Not annotated with @myAnnotation");

        ReflectionUtil.doWithMethods(clsSample, RepeatableAnnotation::methodCallback);
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(MyAnnotations.class)
@interface MyAnnotation {
    int value() default 0;
    String message() default "default message";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotations {
    MyAnnotation [] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface YourAnnotation {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@MyAnnotation(value = 45, message = "manisa")
@interface TheirAnnotation {

}

@MyAnnotation(67)
@MyAnnotation(value = 68, message = "Aksaray")
@TheirAnnotation
class Sample {
    @Command("test")
    @Command
    @Command("foo")
    public static void foo()
    {

    }


    @Commands({@Command, @Command("mest")})
    public static void tar()
    {

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Commands.class)
@interface Command {
    String value() default "";
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Commands {
    Command [] value();
}