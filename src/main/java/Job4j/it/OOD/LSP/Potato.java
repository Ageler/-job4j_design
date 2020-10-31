package Job4j.it.OOD.LSP;

import java.time.LocalDate;

public class Potato extends Food {
    public Potato(String name, LocalDate expaireDate, LocalDate createDate, double price) {
        super(name, expaireDate, createDate, price);
    }
}
