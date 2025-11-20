package org.csystem.app.questions.fighter;

import com.karandev.io.util.console.Console;
import org.csystem.util.array.ArrayUtil;

public class FighterApp {
    public static void run()
    {
        var fighter = new Fighter("Canavar");
        fighter.setAgility(90);
        fighter.setHealth(80);
        fighter.setStrength(70);
        fighter.setSpeed(60);
        Console.writeLine("fighter name: %s", fighter.getName());
        Console.writeLine("fighter total ability: %d", fighter.abilityTotal());
        Console.writeLine("fighter average ability: %f", fighter.abilityAverage());
    }
}


/**
 * Soru: Aşağıdaki demo sınıfı, int türden yeni bir yetenek (ability) eklendiğinde abilityTotal ve abilityAverage metotları değiştirilmek zorunda kalmayacak şekilde güncelleyiniz
 */
/**
class Fighter {
    private String m_name;
    private int m_health;
    private int m_strength;
    private int m_agility;

    public Fighter(String name)
    {
        m_name = name;
    }

    public String getName()
    {
        return m_name;
    }
    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_health;
    }
    public void setHealth(int health)
    {
        m_health = health;
    }

    public int getStrength()
    {
        return m_strength;
    }
    public void setStrength(int strength)
    {
        m_strength = strength;
    }

    public int getAgility()
    {
        return m_agility;
    }
    public void setAgility(int agility)
    {
        m_agility = agility;
    }

    public int abilityTotal()
    {
        return m_health + m_strength + m_agility;
    }

    public double abilityAverage()
    {
        return abilityTotal() / 3.;
    }

}
*/

class Fighter1 {
    private static final int COUNT = 4;
    private String m_name;
    private final int [] m_abilities;

    public Fighter1(String name)
    {
        m_name = name;
        m_abilities = new int[COUNT];
    }

    public String getName()
    {
        return m_name;
    }
    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_abilities[0];
    }
    public void setHealth(int health)
    {
        m_abilities[0] = health;
    }

    public int getStrength()
    {
        return m_abilities[1];
    }
    public void setStrength(int strength)
    {
        m_abilities[1] = strength;
    }

    public int getAgility()
    {
        return m_abilities[2];
    }
    public void setAgility(int agility)
    {
        m_abilities[2] = agility;
    }

    // Adding new ability
    public int getSpeed()
    {
        return m_abilities[3];
    }
    public void setSpeed(int speed)
    {
        m_abilities[3] = speed;
    }
    /// end

    public int abilityTotal()
    {
        return (int)ArrayUtil.sum(m_abilities);
    }

    public double abilityAverage()
    {
        return abilityTotal() / (double) m_abilities.length;
    }

}

class Fighter {
    private String m_name;
    private final int [] m_abilities;
    private enum ABILITY { HEALTH, STRENGTH, AGILITY, SPEED, COUNT };

    public Fighter(String name)
    {
        m_name = name;
        m_abilities = new int[ABILITY.COUNT.ordinal()];
    }

    public String getName()
    {
        return m_name;
    }
    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_abilities[ABILITY.HEALTH.ordinal()];
    }
    public void setHealth(int health)
    {
        m_abilities[ABILITY.HEALTH.ordinal()] = health;
    }

    public int getStrength()
    {
        return m_abilities[ABILITY.STRENGTH.ordinal()];
    }
    public void setStrength(int strength)
    {
        m_abilities[ABILITY.STRENGTH.ordinal()] = strength;
    }

    public int getAgility()
    {
        return m_abilities[ABILITY.AGILITY.ordinal()];
    }
    public void setAgility(int agility)
    {
        m_abilities[ABILITY.AGILITY.ordinal()] = agility;
    }

    public int getSpeed()
    {
        return m_abilities[ABILITY.SPEED.ordinal()];
    }
    public void setSpeed(int speed)
    {
        m_abilities[ABILITY.SPEED.ordinal()] = speed;
    }

    public int abilityTotal()
    {
        return (int)ArrayUtil.sum(m_abilities);
    }

    public double abilityAverage()
    {
        return abilityTotal() / (double) m_abilities.length;
    }
}
