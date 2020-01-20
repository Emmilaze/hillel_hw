package main.carPark;

import main.vehicle.*;

public class CarPark implements ICarPark {

    public Car[] cars;
    private CarParkStorage storage = new CarParkStorage();

    public CarPark() {
        this.cars = storage.getCarsFromFile();
    }

    @Override
    public Car[] sortByFuel() {
        for (int i = cars.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cars[j].getFuelConsumption() > cars[j + 1].getFuelConsumption()) {
                    Car temporal = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temporal;
                }
            }
        }
        storage.putCarsToFile(cars);
        return cars;
    }

    @Override
    public Car[] findBySpeed(int min, int max) {
        Car[] array = new Car[0];
        for (Car car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                array = storage.increaseMassive(array);
                array[array.length - 1] = car;
            }
        }
        return array;
    }

    @Override
    public int countAllCost() {
        int sum = 0;
        for (Car vehicle : cars) {
            sum += vehicle.getPrice();
        }
        return sum;
    }
}
