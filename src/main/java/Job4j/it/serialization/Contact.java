package Job4j.it.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Person person = new Person(false, 30, new Contact(11111, "11111"), "Worker", "Married");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String carJson =
                "{"
                        + "\"new\":false,"
                        + "\"created\":2015,"
                        + "\"model\":"
                        + "{"
                        + "\"BMW\":\"m3\""
                        + "},"
                        + "\"accidents\":"
                        + "[\"20.01.2018\",\"11.08.2020\"]"
                        + "}";
        final Person carMod = gson.fromJson(carJson, Person.class);
        System.out.println(carMod);
        }
    }
