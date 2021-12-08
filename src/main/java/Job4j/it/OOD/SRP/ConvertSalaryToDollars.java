package Job4j.it.OOD.SRP;

import java.util.function.Predicate;

public class ConvertSalaryToDollars implements SalaryConverter, Report {

    private static double DOLLAR = 72.90;

    private Store store;

    ConvertSalaryToDollars(Store store) {
        this.store = store;
    }

    @Override
    public double convert(double salary) {
        return salary / DOLLAR;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(convert(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
