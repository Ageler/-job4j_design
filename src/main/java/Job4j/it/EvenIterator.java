package Job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (!(point < data.length) || data.length == 1) {
            return false;
        }
        while (!isEven(data[point])) {
            point++;
            if (point == data.length) {
                break;
            }
        }
        return point < data.length;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
    public boolean isEven(int i) {
        return i % 2 == 0;
    }
}