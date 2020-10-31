package Job4j.it.OOD.LSP;

import java.util.List;

public class Warehouse implements Storeage{
    @Override
    public void add(Food food) {

    }

    @Override
    public boolean accept(Food food) {
        return false;
    }

    @Override
    public List<Food> clear() {
        return null;
    }
}
