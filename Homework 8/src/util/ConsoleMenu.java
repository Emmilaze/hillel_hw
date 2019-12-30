package util;

import entity.Accessory;
import entity.Flower;
import shop.Bouquet;
import shop.FlowerShop;

import java.util.Scanner;

public class ConsoleMenu {
    private FlowerShop flowerShop;
    private Scanner scanner;
    private Bouquet currentBouquet;

    public ConsoleMenu(FlowerShop flowerShop) {
        this.flowerShop = flowerShop;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        FlowerShop shop = new FlowerShop();
        ConsoleMenu consoleMenu = new ConsoleMenu(shop);
        consoleMenu.greeting();
        System.out.println("Customer:");
        consoleMenu.makeOrder();
    }

    public void greeting() {
        System.out.println("Flower worker:");
        System.out.println("\tWelcome to flower shop!");
        System.out.println("\tCan I help you?");
    }

    public void makeOrder() {
        System.out.println("\t1. Create bouquet");
        System.out.println("\t2. Bouquets operation");
        System.out.println("\t3. Print current bouquet");
        System.out.println("\t4. Leave the shop");

        int choice = getChoice();
        if (choice < 5 && choice > 0) {
            switch (choice) {
                case 1:
                    Bouquet bouquet = new Bouquet();
                    flowerShop.addBouquet(bouquet);
                    currentBouquet = bouquet;
                    createBouquet();
                    break;
                case 2:
                    makeOperations();
                    break;
                case 3:
                    printBouquet();
                    break;
                case 4:
                    exit();
                    break;
            }
        } else {
            System.out.println("Wrong select!");
            makeOrder();
        }
    }

    public void createBouquet() {
        System.out.println("\t1. Add flower");
        System.out.println("\t2. Add accessory");
        System.out.println("\t3. Back");
        int choice = getChoice();
        if (choice < 4 && choice > 0) {
            switch (choice) {
                case 1:
                    addFlower();
                    break;
                case 2:
                    addAccessory();
                    break;
                case 3:
                    makeOrder();
                    break;
            }
        } else {
            System.out.println("Wrong select!");
            createBouquet();
        }
    }

    public void makeOperations() {
        if (flowerShop.getBouquets().length != 0) {
            System.out.println("\t1 Find out all cost");
            System.out.println("\t2 Sort by freshness");
            System.out.println("\t3 Find a flower by the stem");
            System.out.println("\t4 Back");
            int choice = getChoice();
            if (choice < 5 && choice > 0) {
                switch (choice) {
                    case 1:
                        chooseBouquet();
                        System.out.println(flowerShop.calculateCost(currentBouquet));
                        makeOperations();
                        break;
                    case 2:
                        chooseBouquet();
                        flowerShop.sortByFreshness(currentBouquet);
                        printBouquet();
                        makeOperations();
                        break;
                    case 3:
                        chooseBouquet();
                        findByStem(currentBouquet);
                        break;
                    case 4:
                        makeOrder();
                        break;
                }
            } else {
                System.out.println("Wrong select!");
                makeOperations();
            }
        } else {
            System.out.println("First of all you need to create the bouquet!");
            makeOrder();
        }

    }

    public void chooseBouquet() {
        if (flowerShop.getBouquets().length == 0) {
            System.out.println("Please create the bouquet!");
        } else {
            System.out.println("Please choose bouquet:");
            for (int i = 0; i < flowerShop.getBouquets().length; i++) {
                int j = i;
                System.out.println("#" + (j + 1));
                System.out.println(flowerShop.getBouquets()[i].toString());
            }
            int choice = getChoice();
            try {
                currentBouquet = flowerShop.getBouquets()[choice - 1];
            } catch (Exception e) {
                System.out.println("Wrong parameter!");
                chooseBouquet();
            }
        }
    }

    private void addAccessory() {
        System.out.println("Type");
        String type = scanner.nextLine();
        System.out.println("Price");
        int price = Utils.parseToNumber(scanner);
        flowerShop.addAccessoryToBouquet(currentBouquet, new Accessory(price, type));
        createBouquet();
    }

    public void addFlower() {
        System.out.println("Type");
        String type = scanner.nextLine();
        System.out.println("Percentage of freshness");
        int percent = Utils.parseToNumber(scanner);
        System.out.println("Price");
        int price = Utils.parseToNumber(scanner);
        System.out.println("Stem length");
        int length = Utils.parseToNumber(scanner);
        flowerShop.addFlowerToBouquet(currentBouquet, new Flower(price, type, percent, length));
        createBouquet();
    }

    public void printBouquet() {
        for (Bouquet bouquet : flowerShop.getBouquets()) {
            System.out.println(bouquet.toString());
        }
        makeOrder();
    }

    public void exit() {
        scanner.close();
        System.out.println("Thank you!");
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
        System.out.println("Minimum stem size");
        int min = Utils.parseToNumber(scanner);
        System.out.println("Maximum stem size");
        int max = Utils.parseToNumber(scanner);
        for (Flower flower : flowerShop.findByStem(bouquet, min, max)) {
            System.out.println(flower.toString());
        }
        makeOperations();
    }
}