package main.carPark;

import main.vehicle.Car;

public interface ICarPark {
    Car[] sortByFuel();

    Car[] findBySpeed(int min, int max);

    int countAllCost();
}
