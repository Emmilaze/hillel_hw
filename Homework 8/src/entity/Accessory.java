package entity;

public class Accessory extends Entity {
    private String type;

    public Accessory(int price, String type) {
        super(price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
