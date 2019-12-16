package carPark;

import vehicle.Car;

public interface ICarPark {
    Car[] sortByFuel(Car[] car);

    Car[] findBySpeed(Car[] vehicles, int min, int max);

    Car[] increaseMassive(Car[] array);

    int countAllCost(Car[] vehicles);
}
