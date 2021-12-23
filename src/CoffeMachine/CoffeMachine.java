package CoffeMachine;
import java.util.Scanner;

public class CoffeMachine {
    public static void main(String [] args){
        System.out.println("Write how many cups of coffee you will need: ");

        Scanner Scanner = new Scanner(System.in);
        int Users_Input = Scanner.nextInt();
        int WATER = 200;
        int MILK = 50;
        int BEANS = 15;


        System.out.println("For "+ Users_Input + " cups of coffee you will need:\n" +
                +WATER*Users_Input+" ml of water\n" +
                +MILK*Users_Input+" ml of milk\n" +
                +BEANS*Users_Input+" g of coffee beans");
    }
}
