package Job4j.it.OOD.LSP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StartProgramm {
   private final List<Food> stack = new ArrayList<>();

   public void init() {
       stack.add(new Bread("Borodinkii", LocalDate.of(2021, 1, 13),
               LocalDate.now(), 50));
       stack.add(new Doshik("kvisti", LocalDate.of(3022, 1, 21),
               LocalDate.now(), 30));
       stack.add(new Potato("lazurit", LocalDate.of(2020, 11, 8),
               LocalDate.now(), 70));
       stack.add(new Beef("Black angus", LocalDate.of(2020, 12, 30),
               LocalDate.now(), 200));
       stack.add(new Yogurt("Danissimo", LocalDate.of(2020, 11, 17),
               LocalDate.now(), 50));
   }

    public static void main(String[] args) {

    }
}
