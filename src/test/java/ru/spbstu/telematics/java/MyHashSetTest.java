package ru.spbstu.telematics.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashSetTest {
    @Test
    public void testSize() {
        MyHashSet<Integer> set = new MyHashSet<>();
        assertEquals(0, set.size());

        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.size());

        set.remove(2);
        assertEquals(2, set.size());
    }

    @Test
    public void testContains() {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("banana");

        assertTrue(set.contains("apple"));
        assertTrue(set.contains("banana"));
        assertFalse(set.contains("orange"));
    }

    @Test
    public void testAdd() {
        MyHashSet<Integer> set = new MyHashSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));

        assertFalse(set.add(1));

        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertFalse(set.contains(3));

        assertEquals(2, set.size());
    }

    @Test
    public void testRemove() {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("banana");

        assertTrue(set.remove("apple"));
        assertFalse(set.remove("orange"));

        assertEquals(1, set.size());
    }

    @Test
    public void testGet() {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("banana");

        assertEquals("apple", set.get("apple"));
        assertNull(set.get("orange"));
    }

    @Test
    public void testIterator() {
        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        StringBuilder result = new StringBuilder();
        for (Integer element : set) {
            result.append(element).append(", ");
        }

        String expected = result.substring(0, result.length() - 2);

        assertEquals("1, 2, 3", expected);
    }
}
