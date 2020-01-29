package main.vehicle;

public interface Car {
    int getId();

    int getFuelConsumption();

    int getPrice();

    int getSpeed();

    byte[] writeToFile();

    int compareCars(Car o2);
}
