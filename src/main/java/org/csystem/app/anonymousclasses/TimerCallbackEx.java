package org.csystem.app.anonymousclasses;

import com.karandev.io.util.console.Console;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCallbackEx {
    public static void run()
    {
        var timer = new Timer();
        var ch = Console.readChar("Input a char:");

        // first approach
//        timer.scheduleAtFixedRate(new CharacterDisplayTask(ch), 1000, 1000);

        // second approach
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run()
//            {
//                Console.write(ch);
//            }
//        }, 1000, 1000);

        timer.scheduleAtFixedRate(CharacterDisplayUtil.createTimerTask(ch), 500, 500);
        Console.writeLine("Main ends!");
    }
}

// third approach
class CharacterDisplayUtil {
    public static TimerTask createTimerTask(char ch)
    {
        return new TimerTask() {
            public void run()
            {
                Console.write(ch);
            }
        };
    }
}

// first approach
class CharacterDisplayTask extends TimerTask {
    private final char m_character;

    public CharacterDisplayTask(char character)
    {
        m_character = character;
    }

    public void run()
    {
        Console.write(m_character);
    }
}
