package shop;

import entity.Accessory;
import entity.Flower;
import util.Utils;

public class Bouquet {
    private Flower[] flowers;
    private Accessory[] accessories;

    public Bouquet() {
        flowers = new Flower[0];
        accessories = new Accessory[0];
    }

    public void addFlower(Flower flower) {
        flowers = Utils.increaseMassive(flower, flowers);
    }

    public void addAccessory(Accessory accessory) {
        accessories = Utils.increaseMassive(accessory, accessories);
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        String str = "";
        if(flowers.length != 0){
            for (Flower flower : flowers) {
                str += "\nType: " + flower.getFlower() + ", price: " + flower.getPrice() + ", percent of freshness: " +
                        flower.getPercentageOfFreshness() + ", length of stem: " + flower.getStemLength() + ".";
            }
        }
        if(accessories.length != 0){
            for (Accessory accessory : accessories) {
                str += "\nType: " + accessory.getType()+ ", price: " + accessory.getPrice() + ".";
            }
        }
        return str;
    }
}
