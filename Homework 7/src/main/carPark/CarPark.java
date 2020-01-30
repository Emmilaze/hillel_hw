package main.carPark;

import main.vehicle.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarPark implements ICarPark {

    public ArrayList<Car> cars;
    private CarParkStorage storage = new CarParkStorage();

    public CarPark() {
        this.cars = storage.getCarsFromFile();
    }

    private Comparator<Car> fuelComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getFuelConsumption() - o2.getFuelConsumption();
        }
    };

    private Comparator<Car> lambdaComparator = (o1, o2) -> o1.getFuelConsumption() - o2.getFuelConsumption();

    private int compareFuel(Car o1, Car o2){
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }

    public ArrayList<Car> sortByFuel() {
        Collections.sort(cars, fuelComparator);
        Collections.sort(cars, lambdaComparator);
        Collections.sort(cars, Car::compareCars);
        Collections.sort(cars, this::compareFuel);
        storage.putCarsToFile(cars);
        return cars;
    }

    @Override
    public ArrayList<Car> findBySpeed(int min, int max) {
        ArrayList<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                list.add(car);
            }
        }
        return list;
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
