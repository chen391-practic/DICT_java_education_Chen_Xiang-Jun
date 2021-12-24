package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner Scanner = new Scanner(System.in);
        String User_Input = Scanner.nextLine();
        System.out.println("--------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", User_Input.charAt(3 * i + j));
            }
            System.out.println("|");
        }
        System.out.println("--------");
    }
}