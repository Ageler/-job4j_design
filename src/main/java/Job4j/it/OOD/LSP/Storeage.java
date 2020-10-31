package Job4j.it.OOD.LSP;

import java.util.List;

public interface Storeage {
    void add(Food food);
    boolean accept (Food food);
    List<Food> clear();
}
