package Job4j.it.serialization.json;

import Job4j.it.serialization.Driver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.Arrays;

public class Car {

    private boolean damaged;

    private int age;
    private Driver driver;
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

    public static void main(String[] args) {
        final Car car = new Car(false, 5, new Driver(false, 42), "Worker", "Married");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        /* Модифицируем json-строку */
      final String carJson =
                "{"
                        + "\"damaged\":false,"
                        + "\"age\":5,"
                        + "\"driver\":"
                        + "{"
                        + "\"sex\": false,"
                        + "\"age\" : 40"
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);

    }
}
