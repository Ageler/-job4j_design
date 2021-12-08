package Job4j.it.OOD.SRP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class DepartmentFormat implements Format{
    private Store store;

    DepartmentFormat(Store store){
        this.store = store;
    }

    public List<Employee> format(Predicate<Employee> filter, Comparator<Employee> comparator) {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(store.findBy(filter));
        Collections.sort(employees, comparator);
        return employees;
    }

    public List<Employee> format(Predicate<Employee> filter) {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(store.findBy(filter));
        return employees;
    }
}
