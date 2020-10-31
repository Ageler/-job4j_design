package Job4j.it.OOD.LSP;

import java.time.LocalDate;

public class Yogurt extends Food{
    public Yogurt(String name, LocalDate expaireDate, LocalDate createDate, double price) {
        super(name, expaireDate, createDate, price);
    }
}
