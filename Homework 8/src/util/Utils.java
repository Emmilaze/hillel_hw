package util;

import entity.Accessory;
import entity.Flower;
import shop.Bouquet;

import java.util.Scanner;

public class Utils {
    public static Bouquet[] increaseMassive(Bouquet bouquet, Bouquet[] bouquets) {
        Bouquet[] newArray = new Bouquet[bouquets.length + 1];
        for (int i = 0; i < bouquets.length; i++) {
            newArray[i] = bouquets[i];
        }
        newArray[newArray.length - 1] = bouquet;
        return newArray;
    }

    public static int parseToNumber(Scanner scanner) {
        int number = 0;
        while (number == 0)
            try {
                number = Integer.parseInt(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            }
        return number;
    }

    public static Flower[] increaseMassive(Flower flower, Flower[] flowers) {
        Flower[] newArray = new Flower[flowers.length + 1];
        for (int i = 0; i < flowers.length; i++) {
            newArray[i] = flowers[i];
        }
        newArray[newArray.length - 1] = flower;
        return newArray;
    }

    public static Accessory[] increaseMassive(Accessory accessory, Accessory[] accessories) {
        Accessory[] newArray = new Accessory[accessories.length + 1];
        for (int i = 0; i < accessories.length; i++) {
            newArray[i] = accessories[i];
        }
        newArray[newArray.length - 1] = accessory;
        return newArray;
    }
}
