package Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Matrix matrixA = new Matrix(input.nextInt(), input.nextInt());
        matrixA.readMatrix(input);

        Matrix matrixB = new Matrix(input.nextInt(), input.nextInt());
        matrixB.readMatrix(input);

        if (matrixA.getRows() == matrixB.getRows() && matrixA.getCols() == matrixB.getCols()) {
            Matrix result = matrixA.add(matrixB);
            result.print();
        } else {
            System.out.println("ERROR");
        }
    }
}