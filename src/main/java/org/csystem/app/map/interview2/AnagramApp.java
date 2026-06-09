package org.csystem.app.map.interview2;

import com.karandev.io.util.console.Console;
import org.csystem.util.string.StringUtil;

/**
 * Sınıf Çalışması: Parametresi ile aldığı iki tane yazının anagram olup olmadığını test eden areAnagram isimli metodu StringUtil sınıfı içerisinde yazınız. Anagram: Bir yazının harflerinin yerleri değiştirilerek diğer yazı elde edilebiliyorsa bu iki yazıya anagram denir.
 *
 * <p>
 * Örneğin:
 *
 * <pre>
 * "para" ve "arap"
 * "brat" ve "bart"
 * </pre>
 */
public class AnagramApp {
    public static void run()
    {
        Console.writeLine(StringUtil.areAnagram("para", "arap"));
        Console.writeLine(StringUtil.areAnagram("brat", "bart"));
    }
}
