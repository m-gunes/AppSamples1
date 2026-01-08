package org.csystem.app.innerclasses.prompt;

import com.karandev.io.util.console.Console;

public class PromptApp {
    public static void run()
    {
        var prompt = Prompt.Builder.builder()
                .setTitle("Alert")
                .setMessage("Save")
                .setOptionMessage("Yes")
                .setNegativeOption("No")
                .setNeutralOption("Cancel")
                .build();

        var option = prompt.show();

        Console.writeLine(option);
    }
}
