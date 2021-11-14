package Job4j.it.OOD.SRP;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
