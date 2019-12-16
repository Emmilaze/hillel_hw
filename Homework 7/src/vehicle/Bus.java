package vehicle;

public class Bus implements Car {
    private int id;
    private int fuelConsumption;
    private int price;
    private int speed;
    private int numberOfSears;
    private int currentFuel;
    private String color;

    public Bus(int id, int fuelConsumption, int price, int speed, int numberOfSears, int currentFuel, String color) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.numberOfSears = numberOfSears;
        this.currentFuel = currentFuel;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bus #" + getSpeed() + ", numberOfSears = " + numberOfSears + ", currentFuel = " + currentFuel +
                "L, color = " + color + ", fuelConsumption = " + getFuelConsumption() +
                "L/100 km, price = " + getPrice() + "$, speed = " + getSpeed() + "km/h.";
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
