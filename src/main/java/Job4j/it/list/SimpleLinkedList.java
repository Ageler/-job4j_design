package Job4j.it.list;

import java.util.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;


    public void add(T value) {
        Node<T> node = new Node<T>(value, null, null);
        if (head == null || size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = null;
        node.prev = tail;
        tail = node;
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.value;

    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = head.next;
        node.next = null;
        size--;
        return node.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        T value = (T) current.value;
        current.prev = null;
        size--;

        return value;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T e;
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}