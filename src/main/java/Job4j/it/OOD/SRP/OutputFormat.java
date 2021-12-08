package Job4j.it.OOD.SRP;

import java.util.function.Predicate;

public interface OutputFormat {
    String output(Predicate<Employee> filter);
}
