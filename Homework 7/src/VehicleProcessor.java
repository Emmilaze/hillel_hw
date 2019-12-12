import vehicle.Vehicle;

public class VehicleProcessor {
    private static Vehicle[] array = new Vehicle[0];
    private static int index;

    public static void print(Vehicle vehicle) {

    }

    public static void sortByFuel(Vehicle[] vehicle) {
        System.out.println("Sorting:");
        for (int i = vehicle.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vehicle[j].getFuelConsumption() > vehicle[j + 1].getFuelConsumption()) {
                    Vehicle temporal = vehicle[j];
                    vehicle[j] = vehicle[j + 1];
                    vehicle[j + 1] = temporal;
                }
            }
        }
        for (Vehicle car : vehicle) {
            System.out.println("Car # " + car.getId() + ", fuel consumption = " + car.getFuelConsumption());
        }
    }

    public static void findBySpeed(Vehicle[] vehicles, int min, int max) {
        System.out.println("\nCars with speed between 90 and 110 km/h:");
        for (Vehicle car : vehicles) {
            if (car.getSpeed() >= min && car.getSpeed() <= max) {
                array = increaseMassive();
                array[array.length - 1] = car;
                System.out.println(car.toString());
            }
        }
    }

    private static Vehicle[] increaseMassive() {
        Vehicle[] newArray = new Vehicle[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static void countAllCost(Vehicle[] vehicles) {
        int sum = 0;
        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getPrice();
        }
        System.out.println("\nAll cost of carpark: " + sum);
    }
}
