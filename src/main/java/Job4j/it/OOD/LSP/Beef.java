package Job4j.it.OOD.LSP;

import java.time.LocalDate;

public class Beef extends Food{
    public Beef(String name, LocalDate expaireDate, LocalDate createDate, double price) {
        super(name, expaireDate, createDate, price);
    }
}
