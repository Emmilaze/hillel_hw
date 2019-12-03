public class CarProcessor {

    public void findCarByBrand(Car[] cars, String mark) {
        for (Car car : cars) {
            if (car.brand.equals(mark)) {
                print(car);
            }
        }
    }

    public void findCarByModel(Car[] cars, String model, int year) {
        for (Car car : cars) {
            int yearInWork = 2019 - car.year;
            if (car.model.equals(model) && yearInWork >= year) {
                print(car);
            }
        }
    }

    public void findCarByYear(Car[] cars, int year, int price) {
        for (Car car : cars) {
            if (car.year == year && car.price >= price) {
                print(car);
            }
        }
    }

    private void print(Car car) {
        System.out.println("Car id: " + car.id + ", brand: " + car.brand + ", model: " + car.model + ", year of issue: " +
                car.year + ", color: " + car.color + ", price: " + car.price + ", registration number: " + car.number);
    }
}
