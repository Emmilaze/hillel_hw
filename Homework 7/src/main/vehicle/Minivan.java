package main.vehicle;

public class Minivan implements Car {
    private int id;
    private int fuelConsumption;
    private int price;
    private int speed;
    private int numberOfSears;
    private int currentFuel;

    public Minivan(int id, int fuelConsumption, int price, int speed, int numberOfSears, int currentFuel) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.numberOfSears = numberOfSears;
        this.currentFuel = currentFuel;
    }

    @Override
    public String toString() {
        return "Minivan #" + getId() + ", numberOfSears = " + numberOfSears + ", currentFuel = " + currentFuel +
                ", fuelConsumption = " + getFuelConsumption() + "L/100 km, price = " + getPrice() +
                "$, speed = " + getSpeed() + "km/h.";
    }

    public byte[] writeToFile() {
        return ("Minivan, " + getId() + ", " + getFuelConsumption() + ", " + getPrice() + ", " + getSpeed() + ", " +
                numberOfSears + ", " + currentFuel + ";\r\n").getBytes();
    }

    @Override
    public int compareCars(Car o2) {
        return this.getFuelConsumption() - o2.getFuelConsumption();
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
