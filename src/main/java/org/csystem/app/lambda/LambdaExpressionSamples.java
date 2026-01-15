package org.csystem.app.lambda;

import com.karandev.io.util.console.Console;

public class LambdaExpressionSamples {
    public static void run()
    {

        var value = Console.readInt("Input a number:");

        var addOperator1 = new AddOperator(value);
        Console.writeLine(Util.doOperation(10, 20, addOperator1));

        Console.writeLine("----------------------");
        var addOperator2 = new IIntBinaryOperator(){
            public int applyAsInt(int a, int b)
            {
                return a * b * value;
            }
        };

        Console.writeLine(Util.doOperation(10, 20, addOperator2));

        Console.writeLine("----------------------");
        //metot çağrılarındaki lambda ifadelerinde tür belirtilmemesi durumunda ambiguity oluşur.
//        Console.writeLine(Util.doOperation(10, 20, (a, b) -> a + b + value)); // Error
        Console.writeLine(Util.doOperation(10, 20, (int a, int b) -> a + b + value));
        Console.writeLine(Util.doOperation(10, 20, (double a, double b) -> a + b + value));
    }
}

class AddOperator implements IIntBinaryOperator {
    private final int m_value;

    public AddOperator(int value)
    {
        m_value = value;
    }

    public int applyAsInt(int a, int b)
    {
        return a + b + m_value;
    }
}

class Util {
    public static int doOperation(int a, int b, IIntBinaryOperator binaryOperator)
    {
        Console.writeLine("int -> %d %d", a, b);
        return binaryOperator.applyAsInt(a, b);
    }
    public static double doOperation(double a, double b, IDoubleBinaryOperator binaryOperator)
    {
        Console.writeLine("double -> %f %f", a, b);
        return binaryOperator.applyAsDouble(a, b);
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}

interface IDoubleBinaryOperator {
    double applyAsDouble(double a, double b);
}