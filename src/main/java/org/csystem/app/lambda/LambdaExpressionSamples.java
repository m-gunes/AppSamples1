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
        Console.writeLine(Util.doOperation(10, 20, (a, b) -> a + b + value));
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
        Console.writeLine("%d %d", a, b);
        return binaryOperator.applyAsInt(a, b);
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}
