package Job4j.it.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;


@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)

public class Car {
    @XmlAttribute
    private boolean damaged;
    @XmlAttribute
    private int age;
    private Driver driver;

    @XmlElementWrapper(name = "accidents")
    @XmlElement(name = "accident")
    private String[] accidents;

    public Car(boolean damaged, int age, Driver driver, String... accidents) {
        this.damaged = damaged;
        this.age = age;
        this.driver = driver;
        this.accidents = accidents;
    }

    public Car() { }

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
