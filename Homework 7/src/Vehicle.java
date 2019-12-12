public abstract class Vehicle {
    protected int id;
    protected int fuelConsumption;
    protected int price;
    protected int speed;

    public int getId() {
        return id;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public Vehicle(int id, int fuelConsumption, int price, int speed) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
    }

    protected void makeSound(){
        System.out.println("Beep!");
    }

    protected abstract void ride();
}
