package org.csystem.app.map.interview1;

import java.util.*;

/**
 * Sınıf Çalışması: Aşağıdaki açıklamalara göre IStringMap<V> arayüzünü destekleyen StringMap<V> sınıfını yazınız.<p>
 *
 * Açıklamalar:<p>
 *
 * StringMap<V> sınıfının public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz. <p>
 * IStringMap<V> arayüzünde bir değişiklik yapılmayacaktır. Bu arayüz anahtarı string olan map collection sınıfları için implemente edilebilecektir.<p>
 * IStringMap<V> arayüzünün abstract metotları şu şekildedir:<p>
 * count: String map içerisindeki anahtar sayısına geri dönecektir.<p>
 * addElement: Metot, parametresi ile aldığı anahtar ve değeri ekleyecektir. Eğer anahtar daha önce varsa true, yoksa false değerine geri dönecektir. Anahtar değerinin null olması veya blank string olması durumunda IllegalArgumentException fırlatacaktır.<p>
 * removeElement: Metot, parametresi ile aldığı anahtar varsa ve silebilirse true, aksi durumda false değerine geri dönecektir. Anahtar değerinin null veya blank string olması durumunda IllegalArgumentException fırlatacaktır.<p>
 * getValue(String key): Metot, parametresi ile aldığı anahtara karşılık gelen değeri Optional olarak geri dönecektir. Anahtar değerinin null olması veya blank string olması durumunda IllegalArgumentException fırlatacaktır.<p>
 * getValue(String key, V defaultValue): Metot, parametresi ile aldığı anahtara karşılık gelen değere geri dönecektir. Anahtar yoksa ikinci parametresi ile aldığı değere geri dönecektir. Anahtar değerinin null olması veya blank string olması durumunda IllegalArgumentException fırlatacaktır.<p>
 *
 *
 *     IStringMap arayüzü ve StringMap sınıfının public bölümü şu şekildedir:<p>
 * <pre>{@code
 * public interface IStringMap<V> {
 *     int count();
 *     boolean addElement(String key, V value);
 *     boolean removeElement(String key);
 *     Optional<V> getValue(String key);
 *     V getValue(String key, V defaultValue);
 * }
 * }</pre>
 *
 */


public class StringMap<V> implements IStringMap<V> {
    private final HashMap<String, V> m_stringMap = new HashMap<>();

    private static void requireNonNullOrNonBlank(String key)
    {
        if (key == null || key.isBlank())
            throw new IllegalArgumentException();
    }

    @Override
    public int count()
    {
        return m_stringMap.size();
    }

    @Override
    public boolean addElement(String key, V value)
    {
        requireNonNullOrNonBlank(key);

        if (m_stringMap.containsKey(key)) {
            m_stringMap.put(key, value);
            return true;
        } else {
            m_stringMap.put(key, value);
            return false;
        }
    }

    @Override
    public boolean removeElement(String key)
    {
        requireNonNullOrNonBlank(key);

        if (m_stringMap.containsKey(key)) {
            m_stringMap.remove(key);
            return true;
        }
        else
            return false;
    }

    @Override
    public Optional<V> getValue(String key)
    {
        requireNonNullOrNonBlank(key);

        return Optional.ofNullable(m_stringMap.get(key));
    }

    @Override
    public V getValue(String key, V defaultValue)
    {
        requireNonNullOrNonBlank(key);
        var values = m_stringMap.get(key);

        return values == null ? defaultValue : values;
    }
}
