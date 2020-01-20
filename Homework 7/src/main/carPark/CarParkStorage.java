package main.carPark;

import main.vehicle.*;

import java.io.*;

public class CarParkStorage {
    private File inputFile = new File("src/resources/InputListOfCars.txt");
    private File outputFile = new File("src/resources/OutputListOfCars.txt");

    public Car[] getCarsFromFile() {
        String string = "";
        if (inputFile.isFile()) {
            try (FileInputStream fileInputStream = new FileInputStream(inputFile)) {
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer, 0, fileInputStream.available());

                for (int i = 0; i < buffer.length; i++) {
                    string += (char) buffer[i];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getCarsFromByte(string);
    }

    public void putCarsToFile(Car[] cars) {
        if (outputFile.isFile()) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile, false)) {
                for (Car car : cars) {
                    fileOutputStream.write(car.writeToFile());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Car[] getCarsFromByte(String string) {
        Car[] cars = new Car[0];
        for (String car : string.split(";\\r\\n")) {
            String[] carProperties = car.split(", ");
            switch (carProperties[0]) {
                case ("PassengerCar"):
                    cars = increaseMassive(cars);
                    cars[cars.length - 1] = new PassengerCar(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6]), Integer.parseInt(carProperties[7]));
                    break;
                case ("Bus"):
                    cars = increaseMassive(cars);
                    cars[cars.length - 1] = new Bus(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6]));
                    break;
                case ("ElectroCar"):
                    cars = increaseMassive(cars);
                    cars[cars.length - 1] = new ElectroCar(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]));
                    break;
                case ("Minivan"):
                    cars = increaseMassive(cars);
                    cars[cars.length - 1] = new Minivan(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6]));
                    break;
                case ("Truck"):
                    cars = increaseMassive(cars);
                    cars[cars.length - 1] = new Truck(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6]), Integer.parseInt(carProperties[6]));
                    break;
            }
        }
        return cars;
    }

    public Car[] increaseMassive(Car[] array) {
        Car[] newArray = new Car[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
