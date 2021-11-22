package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            menu();
        }
    }

    public static void showStatus() {
        System.out.printf("%nThe coffee machine has:%n");
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", coffee);
        System.out.printf("%d disposable cups%n", cups);
        System.out.printf("$%d of money%n%n", money);
    }

    public static void menu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String answer = scanner.nextLine();
        switch (answer) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                showStatus();
                break;
            case "exit":
                System.exit(0);
            default:
        }

    }

    public static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String answer = scanner.next();
        scanner.nextLine();
        switch (answer) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                break;
        }
        System.out.println();
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
        System.out.println(scanner.nextLine());
    }
    
    public static void take() {
        System.out.printf("%nI gave you $%d%n%n", money);
        money = 0;
    }

    public static void makeEspresso() {
        int waterRequired = 250;
        int milkRequired = 0;
        int coffeeRequired = 16;
        int moneyCost = 4;
        checkMachine(waterRequired, milkRequired, coffeeRequired, moneyCost);
    }

    public static void makeLatte() {
        int waterRequired = 350;
        int milkRequired = 75;
        int coffeeRequired = 20;
        int moneyCost = 7;
        checkMachine(waterRequired, milkRequired, coffeeRequired, moneyCost);
    }

    public static void makeCappuccino() {
        int waterRequired = 200;
        int milkRequired = 100;
        int coffeeRequired = 12;
        int moneyCost = 6;
        checkMachine(waterRequired, milkRequired, coffeeRequired, moneyCost);
    }

    public static void checkMachine(int water, int milk, int coffee, int moneyCost) {
        if (water > CoffeeMachine.water) {
            System.out.println("Sorry, not enough water!");
        } else if (milk > CoffeeMachine.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee > CoffeeMachine.coffee) {
            System.out.println("Sorry, not enough coffee!");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            CoffeeMachine.water -= water;
            CoffeeMachine.milk -= milk;
            CoffeeMachine.coffee -= coffee;
            CoffeeMachine.money += moneyCost;
            CoffeeMachine.cups--;
        }
    }

}
