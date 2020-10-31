package Job4j.it.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray1<T> implements Iterable{
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    public SimpleArray1() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public T set(int index, T e) {
        Objects.checkIndex(index, size);
        T oldValue = (T) elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    public void add(T e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        elementData[index] = null;
        System.arraycopy(elementData, index, elementData, size - 1, size - index);
        size--;

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
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elementData[point++];
            }
        };
    }
}
