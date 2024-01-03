package ru.spbstu.telematics.java;

public class Main {

    public static void main(String[] args) {
        // Пример использования MyHashSet для хранения целых чисел
        MyHashSet<Integer> integerSet = new MyHashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        System.out.println("integerHashSet содержит элементы: " + integerSet);
        System.out.println("Размер integerHashSet: " + integerSet.size());

        integerSet.remove(2);
        System.out.println("integerHashSet после удаления элемента: " + integerSet);
        System.out.println("Размер integerHashSet: " + integerSet.size());

        System.out.println("Содержит элемент 3: " + integerSet.contains(3));
        System.out.println("Содержит элемент 4: " + integerSet.contains(4));
        System.out.println("Получаем элемент 1: " + integerSet.get(1));
        System.out.println("Получаем элемент 5: " + integerSet.get(5) + "\n");

        // Пример использования MyHashSet для хранения булевых значений
        MyHashSet<Boolean> booleanSet = new MyHashSet<>();
        booleanSet.add(true);
        booleanSet.add(false);
        booleanSet.add(true);
        System.out.println("booleanHashSet содержит элементы: " + booleanSet);
        System.out.println("Размер booleanHashSet: " + booleanSet.size());

        booleanSet.remove(true);
        System.out.println("booleanHashSet после удаления элемента: " + booleanSet);
        System.out.println("Размер booleanHashSet: " + booleanSet.size());

        System.out.println("Содержит элемент false: " + booleanSet.contains(false));
        System.out.println("Содержит элемент true: " + booleanSet.contains(true));
        System.out.println("Получаем элемент false: " + booleanSet.get(false));
        System.out.println("Получаем элемент true: " + booleanSet.get(true) + "\n");

        // Пример использования MyHashSet для хранения строк
        MyHashSet<String> stringSet = new MyHashSet<>();
        stringSet.add("apple");
        stringSet.add("banana");
        stringSet.add("orange");
        System.out.println("stringHashSet содержит элементы: " + stringSet);
        System.out.println("Размер stringHashSet: " + stringSet.size());

        stringSet.remove("banana");
        System.out.println("stringHashSet после удаления элемента: " + stringSet);
        System.out.println("Размер stringHashSet: " + stringSet.size());

        System.out.println("Содержит элемент 'apple': " + stringSet.contains("apple"));
        System.out.println("Содержит элемент 'grape': " + stringSet.contains("grape"));

        System.out.println("Получаем элемент 'apple': " + stringSet.get("apple"));
        System.out.println("Получаем элемент 'kiwi': " + stringSet.get("kiwi"));
    }
}
