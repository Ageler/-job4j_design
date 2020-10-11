package Job4j.it;

import java.util.*;
import java.util.stream.*;

public class FlatMap<T> implements Iterator<T> {
    private Iterator<Iterator<T>> data;
    private Iterator<T> cursor;
    private int point = 0;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    List<T> iterList = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(data, Spliterator.ORDERED),
                false)
                .flatMap(x -> StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(x, Spliterator.ORDERED),
                        false))
                .collect(Collectors.toList());


    @Override
    public boolean hasNext() {
        return point < iterList.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterList.get(point++);
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}