package Hangman;
import java.util.Random;

public class Hangman {
    public static void main(String[] args){
            String[] ArrayWords = {"java", "python", "javascript", "kotlin"};
            System.out.println("HANGMAN\nYou guess the word:");
            getRandomWord(ArrayWords);
        }

        static void getRandomWord(String[] array) {
            Random Random = new Random();
            int index = Random.nextInt(array.length);

            if (index == 0) {
                System.out.println("You survived!");
            } else {
                System.out.println("You lost!");
            }
        }
    }
