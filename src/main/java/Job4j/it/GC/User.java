package Job4j.it.GC;
import lombok.Data;

@Data
public class User {
    private int age;
    private String name;

    @Override
    protected void finalize() {
        System.out.println("finalize on air");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            new User();
            System.out.println(Runtime.getRuntime().freeMemory());
        }

    }
}
