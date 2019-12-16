package vehicle;

public class Truck implements Car {
    private int id;
    private int fuelConsumption;
    private int price;
    private int speed;
    private int carryingCapacity;
    private int currentFuel;
    private int carWeight;

    public Truck(int id, int fuelConsumption, int price, int speed, int carryingCapacity, int currentFuel, int carWeight) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.carryingCapacity = carryingCapacity;
        this.currentFuel = currentFuel;
        this.carWeight = carWeight;
    }

    @Override
    public String toString() {
        return "Truck # " + getId() + ", carryingCapacity = " + carryingCapacity + "T, currentFuel = " + currentFuel +
                "L, carWeight=" + carWeight + "T, fuelConsumption = " + getFuelConsumption() + "L/100 km, price = " + getPrice() +
                "$, speed = " + getSpeed() + "km/h.";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
