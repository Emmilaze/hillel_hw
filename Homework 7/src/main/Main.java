package main;

import main.carPark.CarPark;

public class Main {
    public static void main(String[] args) {
        CarPark carPark = new CarPark();
        VehicleView vehicleView = new VehicleView();

        vehicleView.printSorting(carPark.sortByFuel());
        vehicleView.printSpeed(carPark.findBySpeed(90, 110), 90, 100);
        vehicleView.printCost(carPark.countAllCost());
    }
}
