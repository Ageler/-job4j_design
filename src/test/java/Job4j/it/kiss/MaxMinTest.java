package Job4j.it.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void maxIntCompare() {
        MaxMin maxMin = new MaxMin();
        List<Integer> values = List.of(1, 2, 3, 4, 5, -6);
       Integer max = maxMin.max(values, Comparator.comparing(Integer::intValue));
       assertEquals(max.intValue(), 5);
    }

    @Test
    public void maxStringCompare() {
        MaxMin maxMin = new MaxMin();
        List<String> stringValues = List.of("one", "two", "three", "four", "five");
        String max = maxMin.max(stringValues, Comparator.comparing(String::length));
        assertEquals(max, "three");
    }

    @Test
    public void minIntCompare() {
        MaxMin maxMin = new MaxMin();
        List<Integer> values = List.of(1, 2, 3, 4, 5, -6);
        Integer min = maxMin.min(values, Comparator.comparing(Integer::intValue));
        assertEquals(min.intValue(), -6);
    }

    @Test
    public void minStringCompare() {
        MaxMin maxMin = new MaxMin();
        List<String> stringValues = List.of("one", "two", "three", "four", "five");
        String min = maxMin.min(stringValues, Comparator.comparing(String::length));
        assertEquals(min, "one");
    }

}