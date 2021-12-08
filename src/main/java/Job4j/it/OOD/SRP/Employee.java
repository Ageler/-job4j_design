package Job4j.it.OOD.SRP;


import lombok.Data;

import java.util.Calendar;
import java.util.Objects;

@Data
public class Employee {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }


}
