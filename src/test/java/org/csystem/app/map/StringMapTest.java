package org.csystem.app.map;

import org.csystem.app.map.interview1.StringMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class StringMapTest {
    @Test
    void givenValues_whenEqualize_thenReturnTrue()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        stringMap.addElement("Ankara", 6);
        stringMap.addElement("Aksaray", 68);

        Assertions.assertEquals(3, stringMap.count());
    }

    @Test
    void givenExistKey_whenAddElement_thenReturnTrue()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);

        Assertions.assertTrue(stringMap.addElement("istanbul", 34));
    }

    @Test
    void givenNotExistingKey_whenAddElement_thenReturnFalse()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);

        Assertions.assertFalse(stringMap.addElement("Ankara", 6));
    }

    @Test
    void givenNullOrBlankKey_whenAddElement_thenThrowException()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.addElement(null, 7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.addElement("   ", 7));
    }

    @Test
    void givenKey_whenRemovable_thenReturnTrue()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertTrue(stringMap.removeElement("istanbul"));
    }

    @Test
    void givenNonExistingKey_whenRemoveElement_thenReturnFalse()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertFalse(stringMap.removeElement("ankara"));
    }

    @Test
    void givenNullOrBlankKey_whenRemoveElement_thenThrowException()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.removeElement(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.removeElement("  "));
    }

    @Test
    void givenExistingKey_whenGetValue_thenReturnOptionalWithValue()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertEquals(Optional.of(34), stringMap.getValue("istanbul"));
    }

    @Test
    void givenExistingKey_whenGetValue_thenReturnEmptyOptional()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertEquals(Optional.empty(), stringMap.getValue("ankara"));
    }

    @Test
    void givenExistingKeyAndDefaultValue_whenGetValue_thenReturnValue()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertEquals(34, stringMap.getValue("istanbul", 0));
    }

    @Test
    void givenNonExistingKeyAndDefaultValue_whenGetValue_thenReturnDefaultValue()
    {
        StringMap<Integer> stringMap = new StringMap<>();
        stringMap.addElement("istanbul", 34);
        Assertions.assertEquals(-1, stringMap.getValue("ankara", -1));
    }

}
