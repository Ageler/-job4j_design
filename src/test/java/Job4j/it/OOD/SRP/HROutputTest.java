package Job4j.it.OOD.SRP;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class HROutputTest {

    @Test
    public void output() {
        MemStore memStore = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Van", now, now, 100);
        Employee worker2 = new Employee("Billy", now, now, 300);
        Employee worker3 = new Employee("Jabroni", now, now, 10);
        memStore.add(worker1);
        memStore.add(worker2);
        memStore.add(worker3);
        Format format = new DepartmentFormat(memStore);
        OutputFormat outputFormat = new HROutput(format);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), outputFormat.output(employee -> true));
    }
}