package org.csystem.app.optional;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Bir sınıfın bir veri elemanı da optional bir sınıf türünden olabilir. Pratikte çok karşımıza çıkmasa da bazı durumlarda anlamlı olabilmektedir.
 */
public class Student {
    private String m_firstName;
    private Optional<String> m_middleName;
    private String m_familyName;
    private Optional<LocalDate> m_graduationDate;

    public Student(String firstName,String familyName)
    {
        this(firstName, null, familyName, null);
    }

    public Student(String firstName, String middleName, String familyName)
    {
        this(firstName, middleName, familyName, null);
    }

    public Student(String firstName, String familyName, LocalDate graduationDate)
    {
       this(firstName, null, familyName, graduationDate);
    }

    public Student(String firstName, String middleName, String familyName, LocalDate graduationDate)
    {
        m_firstName = firstName;
        m_middleName = Optional.ofNullable(middleName);
        m_familyName = familyName;
        m_graduationDate = Optional.ofNullable(graduationDate);
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public Optional<String> getMiddleName()
    {
        return m_middleName;
    }

    public String getFamilyName()
    {
        return m_familyName;
    }

    public Optional<LocalDate> getGraduationDate()
    {
        return m_graduationDate;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public void setFamilyName(String familyName)
    {
        m_familyName = familyName;
    }

    public void setMiddleName(String middleName)
    {
        m_middleName = Optional.ofNullable(middleName); // important!
    }

    public void setGraduationDate(LocalDate graduationDate)
    {
        m_graduationDate = Optional.ofNullable(graduationDate); // important!
    }
}
