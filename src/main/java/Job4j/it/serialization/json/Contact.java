package Job4j.it.serialization.json;


import lombok.Data;

@Data
public class Contact {
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }
}
