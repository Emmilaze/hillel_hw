package main.carPark;

import main.vehicle.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarParkStorage {
    private File inputFile = new File("src/resources/InputListOfCars.txt");
    private File outputFile = new File("src/resources/OutputListOfCars.txt");

    public ArrayList<Car> getCarsFromFile() {
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
        return (ArrayList<Car>) getCarsFromByte(string);
    }

    public void putCarsToFile(List<Car> cars) {
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

    private List<Car> getCarsFromByte(String string) {
        List<Car> cars = new ArrayList<>();
        for (String car : string.split(";\\r\\n")) {
            String[] carProperties = car.split(", ");
            switch (carProperties[0]) {
                case ("PassengerCar"):
                    cars.add(new PassengerCar(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6]), Integer.parseInt(carProperties[7])));
                    break;
                case ("Bus"):
                    cars.add(new Bus(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6])));
                    break;
                case ("ElectroCar"):
                    cars.add(new ElectroCar(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5])));
                    break;
                case ("Minivan"):
                    cars.add(new Minivan(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6])));
                    break;
                case ("Truck"):
                    cars.add(new Truck(Integer.parseInt(carProperties[1]),
                            Integer.parseInt(carProperties[2]), Integer.parseInt(carProperties[3]),
                            Integer.parseInt(carProperties[4]), Integer.parseInt(carProperties[5]),
                            Integer.parseInt(carProperties[6]), Integer.parseInt(carProperties[6])));
                    break;
            }
        }
        return cars;
    }
}
