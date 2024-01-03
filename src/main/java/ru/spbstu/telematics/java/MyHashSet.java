package ru.spbstu.telematics.java;
import java.util.Iterator;

public class MyHashSet<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<T>[] buckets;
    private int size;

    public MyHashSet() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        int bucketIndex = getBucketIndex(element);
        Node<T> current = buckets[bucketIndex];

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean add(T element) {
        if (!contains(element)) {
            if ((double) (size + 1) / buckets.length > LOAD_FACTOR) {
                resize();
            }

            int bucketIndex = getBucketIndex(element);
            Node<T> newNode = new Node<>(element);
            newNode.next = buckets[bucketIndex];
            buckets[bucketIndex] = newNode;
            size++;
            return true;
        }
        return false;
    }


    public boolean remove(T element) {
        int bucketIndex = getBucketIndex(element);
        Node<T> current = buckets[bucketIndex];
        Node<T> prev = null;

        while (current != null) {
            if (current.data.equals(element)) {
                if (prev == null) {
                    buckets[bucketIndex] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true; // Возвращает true, если элемент найден и удален
            }
            prev = current;
            current = current.next;
        }
        return false; // Возвращает false, если элемент не найден
    }

    public T get(T element) {
        int bucketIndex = getBucketIndex(element);
        Node<T> current = buckets[bucketIndex];

        while (current != null) {
            if (current.data.equals(element)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    private int getBucketIndex(T element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        Node<T>[] newBuckets = new Node[newCapacity];

        for (Node<T> bucket : buckets) {
            Node<T> current = bucket;

            while (current != null) {
                Node<T> next = current.next;
                int bucketIndex = Math.abs(current.data.hashCode()) % newCapacity;
                current.next = newBuckets[bucketIndex];
                newBuckets[bucketIndex] = current;
                current = next;
            }
        }

        buckets = newBuckets;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int bucketIndex = 0;
            private Node<T> current = buckets[bucketIndex];

            @Override
            public boolean hasNext() {
                while (current == null && bucketIndex < buckets.length - 1) {
                    bucketIndex++;
                    current = buckets[bucketIndex];
                }
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

}
