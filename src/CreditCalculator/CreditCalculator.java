package CreditCalculator;
import java.util.Scanner;


public class CreditCalculator {

    public static double A = 0, P = 0, n = 0, i = 0;


    public static void main(String[] args){
        while(true){
            Scanner SCANNER = new Scanner(System.in);
            System.out.println("What do you want to calculate? \n" +
                    "type \"n\" for number of monthly payments,\n" +
                    "type \"a\" for annuity monthly payment amount,\n" +
                    "type \"p\" for loan principal:");

            try{
                String mode = SCANNER.next();
                if(mode.equals("n") || mode.equals("N")){
                    writeData(false,  false,  true);
                    n = absoluteMonth(numberOfPayments(A, P, i));
                    if((n / 12) == 0){
                        System.out.println("It will take " + (int)n + " months to repay this loan! ");
                    }
                    else if((n % 12) == 0){
                        System.out.println("It will take " + (int)(n / 12) + "8 years to repay this loan! ");
                    }
                    else{
                        System.out.println("It will take " + (int)(n / 12) + " years and " + (int)(n % 12) + " months to repay this loan! ");
                    }
                }
                else if(mode.equals("a") || mode.equals("A")){
                    writeData(true,  false,  false);
                    A = absoluteMonth(annualPayment(P, n, i));
                    System.out.println("Your monthly payment = " + (int)A +"! ");
                }
                else if(mode.equals("p") || mode.equals("P")){
                    writeData(false,  true, false);
                    P = (int)principalLoanAmount(A, n, i);
                    System.out.println("Your loan principal = " + (int)P +"! ");
                }
            }
            catch(Exception e){
                System.out.println("Incorrect parameters ");
            }
            System.out.println("-------------------------------------------------");
        }
    }

    private static void writeData(boolean _A, boolean _P, boolean _n){
        Scanner Scanner = new Scanner(System.in);
        if(!_P){
            System.out.println("Enter the loan principal:");
            try {
                P = Scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Incorrect parameters!");
            }
        }
        if(!_A){
            System.out.println("Enter the monthly payment:");
            try {
                A = Scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Incorrect parameter!");
            }
        }
        if(!_n){
            System.out.println("Enter the number of periods:");
            try {
                n = Scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Incorrect parameters!");
            }
        }
        System.out.println("Enter the loan interest:");
        try {
            i = Scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Incorrect parameters!");
        }
    }

    private static double annualPayment(double P, double n, double i){
        i = PROCENT(i);
        return (P * ((i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1)));
    }
    private static double principalLoanAmount(double A, double n, double i){
        i = PROCENT(i);
        return A / ((i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1));
    }
    private static double numberOfPayments(double A, double P, double i){
        i = PROCENT(i);
        return LOG(1 + i, (A / (A - (i * P))));
    }
    private static double Payment(double P, double n, double i, double m){
        return (P / n) + (i * (P - ((P * (m - 1)) / n)));
    }

    private static double LOG(double base, double x){
        return Math.log(x) / Math.log(base);
    }
    private static double PROCENT(double value){
        return (value / (1200));
    }

    private static int absoluteMonth(double MONTH) {
        return (MONTH - (int) MONTH) > 0.0 ? (int) MONTH + 1 : (int) MONTH;
    }
}
