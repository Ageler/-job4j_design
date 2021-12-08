package Job4j.it.OOD.SRP;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HROutput implements OutputFormat{

   private Format hrFormat;

    HROutput(Format hrFormat){
        this.hrFormat = hrFormat;
    }

    @Override
    public String output(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : hrFormat.format(filter, Comparator.comparingDouble(Employee::getSalary))) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
