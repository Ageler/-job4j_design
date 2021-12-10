package Job4j.it.OOD.LSP;

import lombok.Data;

import java.time.*;
import java.util.Objects;

@Data
public abstract class Food {
    private String Name;
    private LocalDate expireDate;
    private LocalDate createDate;
    private double price;
    private float discount = 1;

    public Food(String name, LocalDate expireDate, LocalDate createDate, double price) {
        Name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
    }

    public int isExpired(Food food) {

        LocalDate expireDate = food.getExpireDate();
        LocalDate createDate = food.getCreateDate();

        double productExpirationPeriod = ZonedDateTime.of(expireDate.atStartOfDay(),
                ZoneId.systemDefault()).toInstant().toEpochMilli() -
                ZonedDateTime.of(createDate.atStartOfDay(),
                        ZoneId.systemDefault()).toInstant().toEpochMilli();


        double nowExpirationPeriod = ZonedDateTime.of(expireDate.atStartOfDay(),
                ZoneId.systemDefault()).toInstant().toEpochMilli() -
        Instant.now().toEpochMilli();

        if (productExpirationPeriod * 0.75 < nowExpirationPeriod) {
            return 1;
        } else if (productExpirationPeriod * 0.75 > nowExpirationPeriod
                && nowExpirationPeriod > productExpirationPeriod * 0.25) {
            return 2;
        } else if (productExpirationPeriod * 0.25 < nowExpirationPeriod
                && nowExpirationPeriod < 0) {
            food.setDiscount(0.5f);
            return 3;
        } else
            return 4;
    }


}
