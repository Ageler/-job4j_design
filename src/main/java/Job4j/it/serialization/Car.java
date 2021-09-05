package Job4j.it.serialization;

import java.util.Arrays;

public class Car {
    private final boolean damaged;
    private final int age;
    private final Driver driver;
    private final String[] accidents;

    public Car(boolean damaged, int age, Driver driver, String... accidents) {
        this.damaged = damaged;
        this.age = age;
        this.driver = driver;
        this.accidents = accidents;
    }

    @Override
    public String toString() {
        return "Car{"
                + "damaged=" + damaged
                + ", age=" + age
                + ", driver=" + driver
                + ", accidents=" + Arrays.toString(accidents)
                + '}';
    }
}
