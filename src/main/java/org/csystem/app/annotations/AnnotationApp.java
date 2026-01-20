package org.csystem.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationApp {

}

@TheirAnnotation({"Ali", "Veli", "Selami"})
class Sample {

    @TheirAnnotation({"Ali", "Veli", "Selami"})
    @MyAnnotation(20)
    public void foo()
    {
        //..
    }

    @MyAnnotation(value = 10, message = "Annotated by me")
    public void bar()
    {
        //..
    }

    @YourAnnotation(val = 8)
    public void tar()
    {
        //..
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface TheirAnnotation {
    String [] value();
}

@interface YourAnnotation {
    int val();
}

@interface MyAnnotation {
    String message() default "";
    int value();
}