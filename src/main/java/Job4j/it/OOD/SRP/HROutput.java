package Job4j.it.OOD.SRP;

public class HROutput {

    private HRSort hrSort;

    public HROutput(HRSort hrSort) {
        this.hrSort = hrSort;
    }

    public String output() {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : hrSort.sort()) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
