package Job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    public boolean hasNext() {
        int iter = 0;
        boolean rsl = false;
        while (point < data.length) {
            iter++;
            if(isEven(data[point++])) {
                rsl = true;
                point -= iter;
                break;
            }
        }
        return rsl;
    }

    public Integer next() {
        int rsl = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (point < data.length) {
            if(isEven(data[point])) {
                rsl = data[point++];
                break;
            }
            point++;
        }
        return rsl;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean isEven(int i) {
        return i % 2 == 0;
    }
}
