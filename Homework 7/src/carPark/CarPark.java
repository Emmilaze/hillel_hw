package carPark;

import vehicle.*;

public class CarPark implements ICarPark {

    @Override
    public Car[] sortByFuel(Car[] car) {
        for (int i = car.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (car[j].getFuelConsumption() > car[j + 1].getFuelConsumption()) {
                    Car temporal = car[j];
                    car[j] = car[j + 1];
                    car[j + 1] = temporal;
                }
            }
        }
        return car;
    }

    @Override
    public Car[] findBySpeed(Car[] vehicles, int min, int max) {
        Car[] array = new Car[0];
        for (Car car : vehicles) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                array = increaseMassive(array);
                array[array.length - 1] = car;
            }
        }
        return array;
    }

    @Override
    public Car[] increaseMassive(Car[] array) {
        Car[] newArray = new Car[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public int countAllCost(Car[] vehicles) {
        int sum = 0;
        for (Car vehicle : vehicles) {
            sum += vehicle.getPrice();
        }
        return sum;
    }
}
