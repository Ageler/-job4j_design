package Job4j.it.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};
    private int modCount = 0;




    public SimpleArray() {
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
            modCount++;
        }
        elementData[size++] = e;
        modCount++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        elementData[index] = null;
        System.arraycopy(elementData, index, elementData, size - 1, size - index);
        size--;
        modCount++;

    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }


    @Override
    public Iterator iterator() {

        return new Iterator<T>() {

            final int expectedModCount = modCount;

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
                checkForComodification();
                return (T) elementData[point++];
            }
            final void checkForComodification() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        };
    }

    public static void main(String[] args) {
        ArrayList<Integer> f = new ArrayList();
        f.get(0);
    }
}