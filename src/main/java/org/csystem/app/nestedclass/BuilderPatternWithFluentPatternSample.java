package org.csystem.app.nestedclass;

import com.karandev.io.util.console.Console;

public class BuilderPatternWithFluentPatternSample {
    public static void run()
    {
        var s = new Sample2.Builder()
                .setX(23)
                .setY("Ankara")
                .setT(true)
                .setZ(7)
                .build();

        Console.writeLine(s.getX());
        Console.writeLine(s.getY());
        Console.writeLine("%s", s.getZ());
        Console.writeLine(s.isT());
    }
}


class Sample2 {
    private int m_x;
    private String m_y;
    private float m_z;
    private boolean m_t;


    static class Builder { // nesneyi build eden
        private final Sample2 m_sample; // Sample turden nesnenin referansini tutuyor

        public Builder()
        {
            m_sample = new Sample2(0, "", 0, false);
        }

        public Sample2 build()
        {
            return m_sample;
        }

        public Builder setX(int x)
        {
            m_sample.m_x = x;
            return this;
        }

        public Builder setY(String y)
        {
            m_sample.m_y = y;
            return this;
        }

        public Builder setZ(float z)
        {
            m_sample.m_z = z;
            return this;
        }

        public Builder setT(boolean t)
        {
            m_sample.m_t = t;
            return this;
        }
    }

    private Sample2(int x, String y, float z, boolean t)
    {
        m_x = x;
        m_y = y;
        m_z = z;
        m_t = t;
    }

    public int getX()
    {
        return m_x;
    }

    public String getY()
    {
        return m_y;
    }

    public float getZ()
    {
        return m_z;
    }

    public boolean isT()
    {
        return m_t;
    }
}


