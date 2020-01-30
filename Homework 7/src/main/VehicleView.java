package main;

import main.vehicle.Car;

import java.util.ArrayList;

public class VehicleView {

    public void printSorting(ArrayList<Car> list) {
        for (Car vehicle : list) {
            System.out.println("Vehicle #" + vehicle.getId() + ", fuel consumption: " + vehicle.getFuelConsumption());
        }
    }

    public void printSpeed(ArrayList<Car> list, int min, int max) {
        System.out.println("\nCars with speed between " + min + " and " + max + ":");
        for (Car vehicle : list) {
            System.out.println(vehicle);
        }
    }

    public void printCost(int sum) {
        System.out.println("\nCost of the carpark: " + sum + "$");
    }
}
