package CreditCalculator;
import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args){
        Scanner SCANNER = new Scanner(System.in);
        System.out.println("Enter the loan principal:");
        int PRINCIPAL = SCANNER.nextInt();
        System.out.println(PRINCIPAL);
        System.out.println("What do you want to calculate?\n" +
                "type \"m\" – for number of monthly payments,\n" +
                "type \"p\" – for the monthly payment:");
        String CHOICE = SCANNER.nextLine();

        if (CHOICE.equals("m")){
            System.out.println("Enter the monthly payment:");
            int MONTH = SCANNER.nextInt();
            int SUMM = PRINCIPAL / MONTH;
            System.out.println("It will take " + SUMM + " months to repay the loan");
        }

        if (CHOICE.equals("p")){
            System.out.println("Enter the number payment:");
            int payment = SCANNER.nextInt();
            int sum2 = PRINCIPAL / payment;
            System.out.println("Your monthly payment =" + sum2);
        }
    }
}
