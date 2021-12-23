package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        Scanner Scanner = new Scanner(System.in);
        String bot_name = "HelloGit";
        int bot_year = 2021;
        System.out.println("Hello! My name is " + bot_name + ".");
        System.out.println("I was created in " + bot_year + ".");
        System.out.println("Please, remind your name: ");
        String name = Scanner.nextLine();
        System.out.println("What a great name you have, " +name +"!");
        System.out.println("Let me guess your age.");
        System.out.println("Say me remainders of dividing your age by 3, 5 and 7.");
        int rem3 = Scanner.nextInt();
        int rem5 = Scanner.nextInt();
        int rem7 = Scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");

    }
}
