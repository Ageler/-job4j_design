package Job4j.it.OOD.SRP;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRSort implements SortByPredicate{

    private Store store;
    private Predicate<Employee> predicate;

    public HRSort(Store store, Predicate<Employee> predicate) {
        this.store = store;
        this.predicate = predicate;
    }

    @Override
    public List<Employee> sort() {
        List<Employee> employees = store.findBy(predicate);
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        return employees;
    }
}
