package main.carPark;

import main.vehicle.Car;

import java.util.ArrayList;

public interface ICarPark {
    ArrayList<Car> sortByFuel();

    ArrayList<Car> findBySpeed(int min, int max);

    int countAllCost();
}
