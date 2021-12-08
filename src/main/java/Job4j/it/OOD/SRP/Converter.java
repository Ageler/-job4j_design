package Job4j.it.OOD.SRP;

import java.util.function.Predicate;

public interface Converter {
    String convert(Predicate<Employee> filter);
}
