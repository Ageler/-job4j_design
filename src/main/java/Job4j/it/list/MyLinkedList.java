package Job4j.it.list;

import java.util.*;

public class MyLinkedList<E> implements Iterable {
    Node<E> first;
    Node<E> last;
    int size = 0;
    int modCount = 0;
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    public E get(int index) {
        Objects.checkIndex(index, size);
        return node(index).item;
    }
    Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.get(0);
        linkedList.iterator();
    }

    @Override
    public Iterator iterator() {

        return new Iterator<E>() {

            final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                checkForComodification();
                return  (E) node(point++).next;
            }
            final void checkForComodification() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        };
    }
}
