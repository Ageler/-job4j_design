package Job4j.it.OOD.LSP;

import java.time.LocalDate;

public class Doshik extends Food{
    public Doshik(String name, LocalDate expaireDate, LocalDate createDate, double price) {
        super(name, expaireDate, createDate, price);
    }
}
