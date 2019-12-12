package vehicle;

public class Minivan extends Vehicle {
    private int numberOfSears;
    private int currentFuel;

    public Minivan(int id, int fuelConsumption, int price, int speed, int numberOfSears, int currentFuel) {
        super(id, fuelConsumption, price, speed);
        this.numberOfSears = numberOfSears;
        this.currentFuel = currentFuel;
    }

    private void countSeats() {
        System.out.println(numberOfSears + " passengers can be in the car without driver.");
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
        return "Minivan #" + id + ", numberOfSears = " + numberOfSears + ", currentFuel = " + currentFuel +
                ", fuelConsumption = " + fuelConsumption + "L/100 km, price = " + price + "$, speed = " + speed + "km/h.";
    }
}
