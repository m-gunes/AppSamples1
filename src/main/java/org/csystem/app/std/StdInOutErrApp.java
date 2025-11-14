package org.csystem.app.std;

import java.util.Scanner;

public class StdInOutErrApp {
    public static void run()
    {
        var kb = new Scanner(System.in);

        System.out.print("Input values until zero:");

        var total = 0;
        int val;
        while ((val = kb.nextInt()) != 0)
            total += val;

        System.err.printf("%nError -> Total = %d%n", total);
        System.out.printf("Output -> Total = %d%n", total);
    }
}
