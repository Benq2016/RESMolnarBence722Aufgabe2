package src.Domain;

public class Produkte implements HasName{
    String name;
    Integer price;
    String univerzum;

    public Produkte(String name, int price, String univerzum) {
        this.name = name;
        this.price = price;
        this.univerzum = univerzum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getUniverzum() {
        return this.univerzum;
    }

    @Override
    public String toString() {
        return name +  " " + price + " " + univerzum;
    }
}
