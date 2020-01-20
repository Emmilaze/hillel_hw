package main;

import main.vehicle.Car;

public class VehicleView {

    public void printSorting(Car[] array) {
        for (Car vehicle : array) {
            System.out.println("Vehicle #" + vehicle.getId() + ", fuel consumption: " + vehicle.getFuelConsumption());
        }
    }

    public void printSpeed(Car[] array, int min, int max) {
        System.out.println("\nCars with speed between " + min + " and " + max + ":");
        for (Car vehicle : array) {
            System.out.println(vehicle);
        }
    }

    public void printCost(int sum) {
        System.out.println("\nCost of the carpark: " + sum + "$");
    }
}
