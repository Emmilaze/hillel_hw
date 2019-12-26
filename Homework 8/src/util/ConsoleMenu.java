package util;

import entity.Accessory;
import entity.Flower;
import exceptions.MyException;
import shop.Bouquet;
import shop.FlowerShop;

import java.util.Scanner;

public class ConsoleMenu {
    private FlowerShop flowerShop;
    private Scanner scanner;

    public ConsoleMenu(FlowerShop flowerShop) {
        this.flowerShop = flowerShop;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        FlowerShop shop = new FlowerShop();
        ConsoleMenu consoleMenu = new ConsoleMenu(shop);
        consoleMenu.greeting();
        System.out.println("Customer:");
        consoleMenu.makeOrder(null);
    }

    public void greeting() {
        System.out.println("Flower worker:");
        System.out.println("\tWelcome to flower shop!");
        System.out.println("\tCan I help you?");
    }

    public void makeOrder(Bouquet bouquet) {
        System.out.println("\t1. Create bouquet");
        System.out.println("\t2. Bouquets operation");
        System.out.println("\t3. Print current bouquet");
        System.out.println("\t4. Leave the shop");

        switch (getChoice()) {
            case 1:
                createBouquet(bouquet);
                break;
            case 2:
                makeOperations(bouquet);
                break;
            case 3:
                printBouquet(bouquet);
                break;
            case 4:
                exit();
                break;
        }
    }

    public void createBouquet(Bouquet bouquet) {
        if (bouquet == null)
            bouquet = new Bouquet();
        flowerShop.addBouquet(bouquet);
        System.out.println("\t1. Add flower");
        System.out.println("\t2. Add accessory");
        System.out.println("\t3. Back");

        switch (getChoice()) {
            case 1:
                addFlower(bouquet);
                break;
            case 2:
                addAccessory(bouquet);
                break;
            case 3:
                makeOrder(bouquet);
                break;
        }
    }

    public void makeOperations(Bouquet bouquet) {
        if (bouquet != null) {
            System.out.println("\t1 Find out all cost");
            System.out.println("\t2 Sort by freshness");
            System.out.println("\t3 Find a flower by the stem");
            System.out.println("\t4 Back");

            switch (getChoice()) {
                case 1:
                    System.out.println(flowerShop.calculateCost(bouquet));
                    makeOperations(bouquet);
                    break;
                case 2:
                    printBouquet(flowerShop.sortByFreshness(bouquet));
                    makeOperations(bouquet);
                    break;
                case 3:
                    findByStem(bouquet);
                    break;
                case 4:
                    makeOrder(bouquet);
                    break;
            }
        } else {
            System.out.println("First of all you need to create the bouquet!");
            makeOrder(null);
        }
    }

    private void addAccessory(Bouquet bouquet) {
        System.out.println("Type");
        String type = scanner.nextLine();
        System.out.println("Price");
        int price = Utils.parseToNumber(scanner);
        flowerShop.addAccessoryToBouquet(bouquet, new Accessory(price, type));
        createBouquet(bouquet);
    }

    public void addFlower(Bouquet bouquet) {
        System.out.println("Type");
        String type = scanner.nextLine();
        System.out.println("Percentage of freshness");
        int percent = Utils.parseToNumber(scanner);
        System.out.println("Price");
        int price = Utils.parseToNumber(scanner);
        System.out.println("Stem length");
        int length = Utils.parseToNumber(scanner);
        flowerShop.addFlowerToBouquet(bouquet, new Flower(price, type, percent, length));
        createBouquet(bouquet);
    }

    public void printBouquet(Bouquet bouquet) {
        if (bouquet != null) {
            System.out.println(bouquet.toString());
        } else {
            System.out.println("First of all you need to create the bouquet!");
            makeOrder(null);
        }
        makeOrder(bouquet);
    }

    public void exit() {
        scanner.close();
        System.exit(0);
    }

    public int getChoice() {
        int order = 0;
        while (order == 0) {
            try {
                order = Utils.parseToNumber(scanner);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter the number");
            }
        }
        return order;
    }

    public void findByStem(Bouquet bouquet) {
        try {
            System.out.println("Minimum stem size");
            int min = Utils.parseToNumber(scanner);
            System.out.println("Maximum stem size");
            int max = Utils.parseToNumber(scanner);
            if (min < 0 || max < 0)
                throw new MyException();
            for (Flower flower : flowerShop.findByStem(bouquet, min, max)) {
                System.out.println(flower.toString());
            }
            makeOperations(bouquet);
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("You enter the negative numbers");
            makeOperations(bouquet);
        }
}
}
