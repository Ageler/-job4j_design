package Job4j.it.list;

import junit.framework.TestCase;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest extends TestCase {

    ForwardLinked forwardLinked = new ForwardLinked();

    public void testAdd() {
        forwardLinked.add(1);
        forwardLinked.add(2);
        forwardLinked.add(3);
        Iterator<Integer> it = forwardLinked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    public void testGet() {
        forwardLinked.get(1);
    }
}