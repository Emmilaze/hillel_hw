public class CarProcessor {
    private Car[] array;

    public CarProcessor(Car[] array) {
        this.array = array;
    }

    public CarProcessor() {
        array = new Car[]{};
    }

    private boolean isEmpty() {
        return array.length == 0;
    }

    public void findCarByBrand(String mark) {
        if (!isEmpty()) {
            for (Car car : array) {
                if (car.brand.equals(mark)) {
                    print(car);
                }
            }
        } else {
            System.out.println("Array is empty!");
        }
    }

    public void findCarByModel(String model, int year) {
        if (!isEmpty()) {
            for (Car car : array) {
                int yearInWork = 2019 - car.year;
                if (car.model.equals(model) && yearInWork >= year) {
                    print(car);
                }
            }
        } else {
            System.out.println("Array is empty!");
        }
    }

    public void findCarByYear(int year, int price) {
        if (!isEmpty()) {
            for (Car car : array) {
                if (car.year == year && car.price >= price) {
                    print(car);
                }
            }
        } else {
            System.out.println("Array is empty!");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////

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
