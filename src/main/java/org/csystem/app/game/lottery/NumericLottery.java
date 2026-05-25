package org.csystem.app.game.lottery;

import java.util.TreeSet;
import java.util.random.RandomGenerator;

/*----------------------------------------------------------------------------------------------------------------
Sınıf Çalışması: Sayısal loto kupon üreten programı yazınız.
Açıklama: Bir sayısal loto kuponu birbirinden farklı 6 tane küçükten büyüğe sıralanmış [1, 49] aralığındaki sayılardan oluşur

Anahtar Notlar: Arrays sınıfının sort metodu parametresi ile aldığı diziyi (ascending) artan şekilde sıralar
----------------------------------------------------------------------------------------------------------------*/
public class NumericLottery {
    private final RandomGenerator m_randomGenerator;
    public NumericLottery(RandomGenerator randomGenerator)
    {
        if (randomGenerator == null)
            throw new IllegalArgumentException("Argument can not be null");
        m_randomGenerator = randomGenerator;
    }

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];
        for(int i = 0; i < 6; ++i) {
            int val;
            do
                val = m_randomGenerator.nextInt(1, 50);
            while (flags[val]);

            flags[val] = true;
        }

        return flags;
    }

    private int [] getNumbers(boolean [] flags)
    {
        int [] a = new int[6];
        int idx = 0;

        for(int i = 1; i < flags.length; ++i)
            if(flags[i])
                a[idx++] = i;

        return a;
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }


    /// v2 starts

    public int [] getNumbersWithTreeSet()
    {
        var numbers = new int[6];
        var treeSet = new TreeSet<Integer>();

        while (treeSet.size() != 6)
            treeSet.add(m_randomGenerator.nextInt(1, 50));

        int i = 0;
        for (var val : treeSet)
            numbers[i++] = val;

        return numbers;
    }

}
