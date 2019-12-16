package vehicle;

public class ElectroCar implements Car {
    private int id;
    private int fuelConsumption;
    private int price;
    private int speed;
    private int batteryCharge;
    private String color;

    public ElectroCar(int id, int fuelConsumption, int price, int speed, int batteryCharge, String color) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.batteryCharge = batteryCharge;
        this.color = color;
    }

    @Override
    public String toString() {
        return "ElectroCar #" + getId() + ", battery charge = " + batteryCharge + ", color = " + color +
                ", fuel consumption = " + getFuelConsumption() + ", price = " + getPrice() + ", speed = " +
                getSpeed() + ".";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
