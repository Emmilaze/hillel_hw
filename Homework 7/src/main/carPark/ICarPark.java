package main.carPark;

import main.vehicle.Car;

import java.util.List;

public interface ICarPark {
    List<Car> sortByFuel();

    List<Car> findBySpeed(int min, int max);

    int countAllCost();
}
