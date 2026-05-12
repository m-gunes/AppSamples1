package org.csystem.app.annotations.suppresswarnings;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class SuppressWarningsApp {
    public static void run()
    {

        Object [] objects = {"Ankara", 10, 2.4, new Random()};
        A<String> a = new A<>(objects);

        for (int i = 0; i < a.size(); ++i)
            log.info("a[{}] = {}", i, a.get(i).toUpperCase()); // Error: class java.lang.Integer cannot be cast to class java.lang.String

    }
}

class A<T> {
    private T[] m_list;
    private int m_index;

//    @SuppressWarnings("unchecked") burada SuppressWornings kullanimi dogru degil. uyariyi kaldirsaniz bile runtime daki hata devam ediyor!!!
    public A(Object [] objects)
    {
        m_list = (T[]) objects;
    }

    public int size()
    {
        return m_list.length;
    }
    public T get(int index)
    {
        return m_list[index];
    }

    // not used
    public boolean add(T t)
    {
        if (m_list.length == m_index)
            return false;

        m_list[m_index++] = t;
        return true;
    }
}

class B<T> {
    private T[] m_list;
    private int m_index;

    @SuppressWarnings("unchecked") // burda gonul rahatligi ile SuppressWarning annotation'u ekleyebiliriz. Asagidaki sebeplerden dolayi.
    public B(int size)
    {
        // bu diziye A class'indaki gibi disardan eklemenin imkani yok
        m_list = (T[]) new Object[size]; // burada diziyi disariya vermiyoruz. Dolayisiyla A class'indaki gibi bir runtime error ile karsilasmiyoruz!
    }

    public int size()
    {
        return m_index;
    }

    public T get(int index)
    {
        return m_list[index];
    }

    public boolean add(T t)
    {
        if (m_list.length == m_index)
            return false;

        m_list[m_index++] = t;
        return true;
    }
}