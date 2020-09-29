package Job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean next = false;
        while (row < data.length) {
            if(row < data.length && column < data[row].length) {
                next = true;
                break;
            }
            row++;
        }
        return next;
    }

    @Override
    public Integer next() {
        int ret = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (column + 1 == data[row].length) {
            ret =  data[row][column];
            column = 0;
            row++;
        } else {
            ret = data[row][column];
            column++;
        }
        return ret;
    }
}
