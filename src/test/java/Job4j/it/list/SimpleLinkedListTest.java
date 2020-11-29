package Job4j.it.list;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest extends TestCase {

    ForwardLinked forwardLinked = new ForwardLinked();

    @Test
    public void testAdd() {
        forwardLinked.add(1);
        forwardLinked.add(2);
        forwardLinked.add(3);
        Iterator<Integer> it = forwardLinked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));

    }
    @Test
    public void testGet() {
        forwardLinked.add(1);
        assertThat(forwardLinked.get(0), is(1));
    }
}