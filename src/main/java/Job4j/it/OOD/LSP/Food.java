package Job4j.it.OOD.LSP;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Food {
    private String Name;
    private LocalDate expaireDate;
    private LocalDate createDate;
    private double price;
    private float discount = 0;

    public Food(String name, LocalDate expaireDate, LocalDate createDate, double price) {
        Name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getName() {
        return Name;
    }

    public LocalDate getExpaireDate() {
        return expaireDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 &&
                Float.compare(food.discount, discount) == 0 &&
                Objects.equals(Name, food.Name) &&
                Objects.equals(expaireDate, food.expaireDate) &&
                Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, expaireDate, createDate, price, discount);
    }
}
