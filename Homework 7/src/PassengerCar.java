public class PassengerCar extends Vehicle {
    private int luggageCapacity;
    private int numberOfSears;
    private int currentFuel;

    public PassengerCar(int id, int fuelConsumption, int price, int speed, int luggageCapacity, int numberOfSears, int currentFuel) {
        super(id, fuelConsumption, price, speed);
        this.luggageCapacity = luggageCapacity;
        this.numberOfSears = numberOfSears;
        this.currentFuel = currentFuel;
    }

    @Override
    public String toString() {
        return "PassengerCar #" + id + ", luggage capacity = " + luggageCapacity + " kg, number of sears = " +
                numberOfSears + ", currentFuel = " + currentFuel + "L, fuel consumption = " + fuelConsumption +
                "l/100 km, price = " + price + "$, speed = " + speed + "km/h.";
    }

    @Override
    public void ride() {
        while (currentFuel > 10) {
            makeSound();
            currentFuel -= 5;
        }
        System.out.println("Oops, need more fuel!");
    }
}
