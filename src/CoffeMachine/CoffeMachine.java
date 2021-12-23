package CoffeMachine;
import java.util.Scanner;

public class CoffeMachine {
    int WATER = 400;
    int MILK = 540;
    int BEANS = 120;
    int CUPS = 9;
    int MONEY = 550;

    public static void main(String[] args) {
        CoffeMachine main = new CoffeMachine(); main.START();
    }

    public void START() {
        Scanner in = new Scanner(System.in);
        boolean isexit = false;
        while (!isexit) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = in.next();
            isexit = modifyState(action, in);
        }
        in.close();
    }

    private void STANDART_AVAILABILITY() {
        System.out.println("The coffee machine has: ");
        System.out.println(this.WATER + " of water");
        System.out.println(this.MILK + " of milk");
        System.out.println(this.BEANS + " of coffee beans");
        System.out.println(this.CUPS + " of disposable cups");
        System.out.println("$" + this.MONEY + " of money");
    }

    private void COMP_ORDER(int water, int milk, int beans, int money) {
        if (CUPS > 0 && this.WATER - water >= 0 && this.MILK - milk >= 0 && this.BEANS - beans >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
            this.CUPS--;
            this.WATER -= water;
            this.MILK -= milk;
            this.BEANS -= beans;
            this.MONEY += money;
        } else {
            System.out.println("Sorry, not enough " +
                    (CUPS <= 0 ? "cups" : this.WATER - water < 0 ? "water" : this.MILK - milk < 0 ? "milk" : "beans")
                    + "!");
        }
    }

    private boolean modifyState(String action, Scanner Scanner) {
        System.out.println();
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                switch (Scanner.next()) {
                    case "1":
                        COMP_ORDER(250, 0, 16, 4);
                        break;
                    case "2":
                        COMP_ORDER(350, 75, 20, 7);
                        break;
                    case "3":
                        COMP_ORDER(200, 100, 12, 6);
                        break;
                    case "back":
                        return false;
                    default:
                        break;
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                this.WATER += Scanner.nextInt();
                //
                System.out.println("Write how many ml of milk do you want to add: ");
                this.MILK += Scanner.nextInt();
                //
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                this.BEANS += Scanner.nextInt();
                //
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                this.CUPS += Scanner.nextInt();
                break;
            case "take":
                System.out.println("I gave you " + this.MONEY + "$");
                this.MONEY = 0;
                break;
            case "remaining":
                this.STANDART_AVAILABILITY();
                break;
            case "exit":
                return true;
            default:
                break;
        }
        return false;
    }
}