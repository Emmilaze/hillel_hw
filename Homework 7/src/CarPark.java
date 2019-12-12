import vehicle.*;

public class CarPark {

    public static void main(String[] args) {
        Vehicle[] carPark = new Vehicle[]{
                new PassengerCar(1, 10, 3000, 120, 120, 4, 66),
                new PassengerCar(2, 6, 1500, 80, 70, 4, 40),
                new PassengerCar(3, 10, 6000, 160, 150, 5, 89),
                new Truck(4, 15, 4000, 70, 29, 63, 7),
                new Truck(5, 13, 7000, 100, 13, 50, 10),
                new Minivan(6, 11, 2000, 100, 8, 48),
                new Bus(7, 18, 8000, 120, 22, 99, "black"),
                new ElectroCar(8, 0, 3000, 90, 78, "red"),
                new ElectroCar(9, 8, 2500, 100, 5, "white")};

        VehicleProcessor.sortByFuel(carPark);
        VehicleProcessor.findBySpeed(carPark, 90, 110);
        VehicleProcessor.countAllCost(carPark);
    }
}
