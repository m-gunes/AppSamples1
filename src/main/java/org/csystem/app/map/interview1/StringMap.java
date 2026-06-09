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
    private final Map<String, V> m_stringMap = new HashMap<>();

    private static void throwIfKeyNullOrBlank(String key)
    {
        if (key == null || key.isBlank())
            throw new IllegalArgumentException("Key can not be null or blank");
    }

    @Override
    public int count()
    {
        return m_stringMap.size();
    }

    @Override
    public boolean addElement(String key, V value)
    {
        throwIfKeyNullOrBlank(key);
        boolean exists = m_stringMap.containsKey(key);
        m_stringMap.put(key, value);

        return exists;
    }

    @Override
    public boolean removeElement(String key)
    {
        throwIfKeyNullOrBlank(key);
        boolean exists = m_stringMap.containsKey(key);
        m_stringMap.remove(key);

        return exists;
    }

    @Override
    public Optional<V> getValue(String key)
    {
        throwIfKeyNullOrBlank(key);

        return Optional.ofNullable(m_stringMap.get(key));
    }

    @Override
    public V getValue(String key, V defaultValue)
    {
        throwIfKeyNullOrBlank(key);
        return m_stringMap.getOrDefault(key, defaultValue);
    }
}
