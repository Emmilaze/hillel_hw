package entity;

public abstract class Entity {
    public int price;

    public Entity(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
