package main;

import main.vehicle.Car;

import java.util.List;

public class VehicleView {

    public void printSorting(List<Car> list) {
        for (Car vehicle : list) {
            System.out.println("Vehicle #" + vehicle.getId() + ", fuel consumption: " + vehicle.getFuelConsumption());
        }
    }

    public void printSpeed(List<Car> list, int min, int max) {
        System.out.println("\nCars with speed between " + min + " and " + max + ":");
        for (Car vehicle : list) {
            System.out.println(vehicle);
        }
    }

    public void printCost(int sum) {
        System.out.println("\nCost of the carpark: " + sum + "$");
    }
}
