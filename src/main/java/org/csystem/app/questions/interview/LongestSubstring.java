package org.csystem.app.questions.interview;

public class LongestSubstring {
    public static void run(String[] args)
    {
        String s = "pickoutthelongestsubstring";
        solution2(s);
    }

    private static void solution2(String s) // yes this is the solution but not efficient one
    {
        int maxLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < s.length(); ++j) {
                if (currentSubstring.indexOf(String.valueOf(s.charAt(j))) != -1)
                    break;

                currentSubstring.append(s.charAt(j));
                maxLength = Math.max(maxLength, currentSubstring.length());

                // Math.max bunu yapiyor zaten
//                if (currentSubstring.length() > maxLength)
//                    maxLength = currentSubstring.length();

            }
        }

        System.out.printf("maxLength: %d %n", maxLength);
    }

    private static void solution1(String s) // not sure about this solution
    {
        int longestStr = 0;

        for (int i = 0; i < s.length(); ++i) {
            String subStr = s.substring(i + 1, s.length());
            int index = subStr.indexOf(s.charAt(i));

            System.out.printf("char: %c, subStr: %s, index: %d %n", s.charAt(i), subStr, index);

            if (index <= 0) {
                ++longestStr;
                continue;
            }

            else if (index > longestStr)
                longestStr = 0;
        }

        System.out.println(longestStr);
    }
}
