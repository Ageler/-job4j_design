package Job4j.it.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable{
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    public SimpleArray() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public Object set(int index, T e) {
        Objects.checkIndex(index, size);
        Object oldValue = elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    public void add(T e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;

        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }


    @Override
    public Iterator iterator() {

        return new Iterator() {

            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < elementData.length;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementData[point++];
            }
        };
    }
}
