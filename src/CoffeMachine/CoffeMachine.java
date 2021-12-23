package CoffeMachine;
import java.util.Scanner;

public class CoffeMachine {
    public static void main(String [] args){
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has:");
        int WATER = Scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has:");
        int MILK = Scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has:");
        int BEANS = Scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need:");
        int CUPS = Scanner.nextInt();
        //
        int F1 = WATER / 200;
        int F2 = MILK / 50;
        int F3 = BEANS / 15;
        //
        int Limitation = Math.min(F1, Math.min(F2, F3));

        if (CUPS > Limitation) {
            System.out.println("No, I can make only " + Limitation + " cup(s) of coffee");
        } else if (CUPS == Limitation) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            int Availability = Limitation - CUPS;
            System.out.println("Yes, I can make that amount of coffee (and even " + Availability + " more than that)");
        }
    }

}
