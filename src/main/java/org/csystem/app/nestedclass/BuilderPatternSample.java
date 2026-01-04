package org.csystem.app.nestedclass;

import com.karandev.io.util.console.Console;

public class BuilderPatternSample {
    public static void run()
    {
        var builder = new Sample.Builder();
        builder.setX(23);
        builder.setY("Istanbul");

        var s = builder.build();

        Console.writeLine(s.getX());
        Console.writeLine(s.getY());
        Console.writeLine("%s", s.getZ());
        Console.writeLine(s.isT());
    }
}


class Sample {
    private int m_x;
    private String m_y;
    private float m_z;
    private boolean m_t;


    static class Builder { // nesneyi build eden
        private final Sample m_sample; // Sample turden nesnenin referansini tutuyor

        public Builder()
        {
            m_sample = new Sample(0, "", 0, false);
        }

        public Sample build()
        {
            return m_sample;
        }

        public void setX(int x)
        {
            m_sample.m_x = x;
        }

        public void setY(String y)
        {
            m_sample.m_y = y;
        }

        public void setZ(float z)
        {
            m_sample.m_z = z;
        }

        public void setT(boolean t)
        {
            m_sample.m_t = t;
        }
    }

    private Sample(int x, String y, float z, boolean t)
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


