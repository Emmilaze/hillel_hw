package vehicle;

public class ElectroCar extends Vehicle {
    private int batteryCharge;
    private String color;

    public ElectroCar(int id, int fuelConsumption, int price, int speed, int batteryCharge, String color) {
        super(id, fuelConsumption, price, speed);
        this.batteryCharge = batteryCharge;
        this.color = color;
    }

    @Override
    public void ride() {
        while (batteryCharge > 20) {
            makeSound();
            batteryCharge -= 5;
        }
        System.out.println("Oops, need charge!");
    }

    @Override
    public String toString() {
        return "ElectroCar #" + id + ", battery charge = " + batteryCharge + ", color = " + color +
                ", fuel consumption = " + fuelConsumption + ", price = " + price + ", speed = " + speed + ".";
    }
}
