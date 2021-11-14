package Job4j.it.OOD.SRP;

public class ConvertSalaryToDollars implements SalaryConverter{

    private static double DOLLAR = 72.90;

    @Override
    public double convert(double salary) {
        return salary/DOLLAR;
    }
}
