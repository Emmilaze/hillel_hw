package main.carPark;

import main.vehicle.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarPark implements ICarPark {

    public List<Car> cars;
    private CarParkStorage storage = new CarParkStorage();

    public CarPark() {
        this.cars = storage.getCarsFromFile();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    private Comparator<Car> fuelComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getFuelConsumption() - o2.getFuelConsumption();
        }
    };

    private Comparator<Car> lambdaComparator = (o1, o2) -> o1.getFuelConsumption() - o2.getFuelConsumption();

    private int compareFuel(Car o1, Car o2) {
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }

    public List<Car> sortByFuel() {
//        Collections.sort(cars, fuelComparator);
//        Collections.sort(cars, lambdaComparator);
//        Collections.sort(cars, Car::compareCars);
//        Collections.sort(cars, this::compareFuel);
        setCars(cars.stream()
                .sorted(Comparator.comparingInt(Car::getFuelConsumption))
                .collect(Collectors.toList()));
        storage.putCarsToFile(cars);
        return cars;
    }

    @Override
    public List<Car> findBySpeed(int min, int max) {
        return cars.stream()
                .filter(car -> (car.getSpeed() >= min && car.getSpeed() <= max))
                .collect(Collectors.toList());
    }

    @Override
    public int countAllCost() {
        return cars.stream().reduce(0,
                (x, y) -> {
                    return x + y.getPrice();
                }, (x, y) -> x + y);
    }

    @Override
    public String toString() {
        return cars.stream().map(n -> n.toString())
                .collect(Collectors.joining("\n"));
    }
}
