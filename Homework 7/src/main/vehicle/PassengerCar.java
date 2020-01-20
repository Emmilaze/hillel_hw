package main.vehicle;

public class PassengerCar implements Car {
    private int id;
    private int fuelConsumption;
    private int price;
    private int speed;
    private int luggageCapacity;
    private int numberOfSears;
    private int currentFuel;

    public PassengerCar(int id, int fuelConsumption, int price, int speed, int luggageCapacity, int numberOfSears, int currentFuel) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.luggageCapacity = luggageCapacity;
        this.numberOfSears = numberOfSears;
        this.currentFuel = currentFuel;
    }

    @Override
    public String toString() {
        return "PassengerCar #" + getId() + ", luggage capacity = " + luggageCapacity + " kg, number of sears = " +
                numberOfSears + ", currentFuel = " + currentFuel + "L, fuel consumption = " + getFuelConsumption() +
                "l/100 km, price = " + getPrice() + "$, speed = " + getSpeed() + "km/h.";
    }

    @Override
    public byte[] writeToFile() {
        return ("PassengerCar, " + getId() + ", " + getFuelConsumption() + ", " + getPrice() + ", " + getSpeed() + ", "
                + luggageCapacity + ", " + numberOfSears + ", " + currentFuel + ";\r\n").getBytes();
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
