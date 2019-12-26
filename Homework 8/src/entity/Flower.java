package entity;

public class Flower extends Entity {
    private String flower;
    private int percentageOfFreshness;
    private int stemLength;

    public Flower(int price, String flower, int percentageOfFreshness, int stemLength) {
        super(price);
        this.flower = flower;
        this.percentageOfFreshness = percentageOfFreshness;
        this.stemLength = stemLength;
    }

    public String getFlower() {
        return flower;
    }

    public int getPercentageOfFreshness() {
        return percentageOfFreshness;
    }

    public int getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flower='" + flower + '\'' +
                ", percentageOfFreshness=" + percentageOfFreshness +
                ", stemLength=" + stemLength +
                ", price=" + price +
                '}';
    }
}
