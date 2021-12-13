package Job4j.it.serialization.json;

import Job4j.it.serialization.Driver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main1 {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[] {"Worker", "Married"});
        final Car car = new Car(false, 5, new Driver(false, 42), "Worker", "Married");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        String jsonCar = gson.toJson(car);
        System.out.println(jsonCar);


        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Car carMod = gson.fromJson(jsonCar, Car.class);
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
        System.out.println(carMod);
    }
}
