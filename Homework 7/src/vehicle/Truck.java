package vehicle;

public class Truck extends Vehicle {
    private int carryingCapacity;
    private int currentFuel;
    private int carWeight;

    public Truck(int id, int fuelConsumption, int price, int speed, int carryingCapacity, int currentFuel, int carWeight) {
        super(id, fuelConsumption, price, speed);
        this.carryingCapacity = carryingCapacity;
        this.currentFuel = currentFuel;
        this.carWeight = carWeight;
    }

    @Override
    public void ride() {
        while (currentFuel > 10) {
            System.out.println();
            currentFuel -= 5;
        }
        System.out.println("Oops, need more fuel!");
    }

    @Override
    public String toString() {
        return "Truck # " + id + ", carryingCapacity = " + carryingCapacity + "T, currentFuel = " + currentFuel +
                ", carWeight=" + carWeight + "T, fuelConsumption = " + fuelConsumption + "L/100 km, price = " + price +
                "$, speed = " + speed + "km/h.";
    }
}
