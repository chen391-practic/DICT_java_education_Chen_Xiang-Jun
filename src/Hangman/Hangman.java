package Hangman;
import java.util.Random;
import java.util.Objects;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        String[] ArrayWords = {"java", "python", "javascript", "kotlin"};
        System.out.println("HANGMAN\nYou guess the word:");
        int Random = new Random().nextInt(ArrayWords.length);
        String RepLetters = ArrayWords[Random];
        System.out.print(RepLetters.charAt(0));
        System.out.print(RepLetters.charAt(1));
        for (int i = 2; i < RepLetters.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        String user_input = Scanner.nextLine();
        if (Objects.equals(user_input, RepLetters)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }

}
