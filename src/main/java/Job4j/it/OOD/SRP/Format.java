package Job4j.it.OOD.SRP;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface Format {
    List<Employee> format(Predicate<Employee> filter);

    List<Employee> format(Predicate<Employee> filter, Comparator<Employee> comparingDouble);
}
