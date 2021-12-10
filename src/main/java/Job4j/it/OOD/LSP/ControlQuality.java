package Job4j.it.OOD.LSP;

import java.sql.Timestamp;

public class ControlQuality {

    private Storage storage;

    public ControlQuality(Storage storage) {
        this.storage = storage;
    }

    public void distribute(Food food) {

        storage.add(food);
    }
}
