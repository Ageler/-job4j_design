package Job4j.it.OOD.LSP;

import java.time.LocalDate;

public class Bread extends Food{
    public Bread(String name, LocalDate expaireDate, LocalDate createDate, double price) {
        super(name, expaireDate, createDate, price);
    }
}
