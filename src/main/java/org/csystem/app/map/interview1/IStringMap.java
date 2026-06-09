package org.csystem.app.map.interview1;

import java.util.Optional;

public interface IStringMap<V> {
    int count();
    boolean addElement(String key, V value);
    boolean removeElement(String key);
    Optional<V> getValue(String key);
    V getValue(String key, V defaultValue);
}