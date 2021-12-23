package CoffeMachine;
import java.util.Scanner;


public class CoffeMachine {

    static int WATER = 400;
    static int MILK = 540;
    static int BEANS = 120;
    static int CUPS = 9;
    static int MONEY = 550;

    static Boolean exit = false;

    static Scanner scanner = new Scanner(System.in);

    enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    static Status curStatus = Status.CHOOSING;

    public static void main(String[] args) {


        do {
            System.out.println(curStatus);
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    curStatus = Status.BUYING;
                    System.out.println(curStatus);
                    buy();
                    break;
                case "fill":
                    curStatus = Status.FILLING;
                    System.out.println(curStatus);
                    fill();
                    break;
                case "take":
                    curStatus = Status.TAKING;
                    System.out.println(curStatus);
                    take();
                    break;
                case "remaining":
                    curStatus = Status.REMAINING;
                    System.out.println(curStatus);
                    remaining();
                    break;
                case "exit":
                    exit();
                    System.out.println(curStatus);
                    break;
            }
        } while (curStatus != Status.EXITING);


    }

    static void buy() {
        System.out.println();
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();
        switch (choice) {
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    WATER -= 250;
                    BEANS -= 16;
                    CUPS--;
                    MONEY += 4;
                    break;
                }
            }
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    WATER -= 350;
                    MILK -= 75;
                    BEANS -= 20;
                    CUPS--;
                    MONEY += 7;
                    break;
                }
            }
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    WATER -= 200;
                    MILK -= 100;
                    BEANS -= 12;
                    CUPS--;
                    MONEY += 6;
                    break;

                }

            }
            case "back": {
                break;
            }
            default: {
                break;
            }

        }
        curStatus = Status.CHOOSING;
    }

    static void fill() {
        System.out.println();
        System.out.print("Write how many ml of water do you want to add: ");
        int waterAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many ml of milk do you want to add: ");
        int milkAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        int beansAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        int cupsAdd = scanner.nextInt();
        System.out.println();
        WATER += waterAdd;
        MILK += milkAdd;
        BEANS += beansAdd;
        CUPS += cupsAdd;

        curStatus = Status.CHOOSING;
    }

    static void take() {
        System.out.println("I gave you $" + MONEY +"\n");
        MONEY = 0;

        curStatus = Status.CHOOSING;
    }

    static void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(WATER + " of water");
        System.out.println(MILK + " of milk");
        System.out.println(BEANS + " of coffee beans");
        System.out.println(CUPS + " of disposable cups");
        System.out.println(MONEY + " of money");
        System.out.println();

        curStatus = Status.CHOOSING;
    }

    static void exit() {
        curStatus = Status.EXITING;
    }

    static boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        if (WATER >= waterNeed) {
            if (MILK >= milkNeed) {
                if (BEANS >= beansNeed) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

}