package Hangman;
import java.util.Random;
import java.util.Scanner;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import java.util.ArrayList;

public class Hangman {
    public static void main(String[] args) {
        ArrayList GuessedLetters = new ArrayList();
        Scanner Scanner = new Scanner(System.in);
        String[] ArrayWords = {"java", "python", "javascript", "kotlin"};
        System.out.println("HANGMAN");
        int Random = new Random().nextInt(ArrayWords.length);
        String RepLetters = ArrayWords[Random];
        String temp_word = RepLetters.replaceAll("[a-z]", "-");
        StringBuilder BuildHideWords = new StringBuilder(temp_word);
        System.out.println(BuildHideWords);
        int i = 0;
        while (i < 8) {
            System.out.print("Input a letter:");
            String User_input = Scanner.nextLine();
            if (GuessedLetters.contains(User_input.charAt(0))) {
                System.out.println("No Improvements");
                i++;
                continue;
            }
            if (!RepLetters.contains(User_input)) {
                System.out.println("That letter doesnt appear in the word!");
                i++;
                continue;
            }
            GuessedLetters.add(User_input.charAt(0));

            for (int n = 0; n < BuildHideWords.length(); n++) {
                if (RepLetters.charAt(n) == User_input.charAt(0)){
                    BuildHideWords.setCharAt(n, User_input.charAt(0));

                }
                   }
                System.out.println(BuildHideWords);
                long CheckLettersInWords = StringUtils.countChar(BuildHideWords.toString(), '-');
                if (CheckLettersInWords == 0)
                    break;

            }
        if (i == 8) {
            System.out.println("You lost!");
            return;

        }
        System.out.println("Thanks for playing!");
        System.out.println("Well see how well you did in the next stage");
    }

}