package Job4j.it.OOD.LSP;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Storage {
    void add(Food food);

    boolean accept(Food food);

    List<Food> clear();

    default int calculate(Food food) {
        LocalDate start = food.getCreateDate();
        LocalDate end = food.getExpireDate();
        LocalDate now = LocalDate.now();
        long allDays = ChronoUnit.DAYS.between(start, end);
        long remainDays = ChronoUnit.DAYS.between(now, end);
        return (int) (remainDays / (allDays / 100.0));
    }
}
