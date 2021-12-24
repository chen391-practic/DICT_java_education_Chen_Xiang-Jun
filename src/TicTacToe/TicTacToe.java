package TicTacToe;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;



class OutBoundsMoveException extends Exception {}
class OccupiedCoordinateException extends Exception {}


class Coordinates {
    public final int x;
    public final int y;
    Coordinates(int x, int y) throws OutBoundsMoveException {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            throw new OutBoundsMoveException();
        }
        this.x = x;
        this.y = y;
    }
}

public class TicTacToe {

    public static String[][] getRows(String[] gameState) {
        //GameBoard
        String[][] rows = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(gameState, i * 3, rows[i], 0, 3);
        }
        return rows;
    }

    public static String[][] getCols(String[] GAMEBOARD) {
        String[][] colls = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                colls[i][j] = GAMEBOARD[i + 3 * j];
            }
        }
        return colls;
    }

    public static boolean LineOf(String player, String[] line) {
        String[] expected_Line = new String[]{player, player, player};
        return Arrays.equals(line, expected_Line);
    }

    public static boolean LinesOf(String PLAYER, String[][] lines) {
        for (String[] line : lines) {
            if (LineOf(PLAYER, line)) {
                return true;
            }
        }
        return false;
    }

    public static boolean RowOf(String player, String[] GAMEBOARD) {
        return LinesOf(player, getRows(GAMEBOARD));
    }

    public static boolean isColOf(String player, String[] GAMEBOARD) {
        return LinesOf(player, getCols(GAMEBOARD));
    }

    public static boolean isRowOfXs(String[] GAMEBOARD) {
        return RowOf("X", GAMEBOARD);
    }

    public static boolean isRowOfOs(String[] GAMEBOARD) {
        return RowOf("O", GAMEBOARD);
    }

    public static boolean isColOfXs(String[] GAMEBOARD) {
        return isColOf("X", GAMEBOARD);
    }

    public static boolean isColOfOs(String[] GAMEBOARD) {
        return isColOf("O", GAMEBOARD);
    }

    public static String[] getRightDiagonal(String[] GAMEBOARD) {
        return new String[]{GAMEBOARD[0], GAMEBOARD[4], GAMEBOARD[8]};
    }

    public static String[] getLeftDiagonal(String[] GAMEBOARD) {
        return new String[]{GAMEBOARD[2], GAMEBOARD[4], GAMEBOARD[6]};
    }

    public static boolean isRightDiagonalOf(String player, String[] GAMEBOARD) {
        return LineOf(player, getRightDiagonal(GAMEBOARD));
    }

    public static boolean isLeftDiagonalOf(String player, String[] GAMEBOARD) {
        return LineOf(player, getLeftDiagonal(GAMEBOARD));
    }

    public static boolean isRightDiagonalOfXs(String[] GAMEBOARD) {
        return isRightDiagonalOf("X", GAMEBOARD);
    }

    public static boolean isRightDiagonalOfOs(String[] GAMEBOARD) {
        return isRightDiagonalOf("O", GAMEBOARD);
    }

    public static boolean isLeftDiagonalOfXs(String[] GAMEBOARD) {
        return isLeftDiagonalOf("X", GAMEBOARD);
    }

    public static boolean isLeftDiagonalOfOs(String[] GAMEBOARD) {
        return isLeftDiagonalOf("O", GAMEBOARD);
    }

    public static boolean isDiagonalOfXs(String[] GAMEBOARD) {
        return isRightDiagonalOfXs(GAMEBOARD) || isLeftDiagonalOfXs(GAMEBOARD);
    }

    public static boolean isDiagonalOfOs(String[] GAMEBOARD) {
        return isRightDiagonalOfOs(GAMEBOARD) || isLeftDiagonalOfOs(GAMEBOARD);
    }

    public static boolean isXWins(String[] GAMEBOARD) {
        return isRowOfXs(GAMEBOARD) || isColOfXs(GAMEBOARD) || isDiagonalOfXs(GAMEBOARD);
    }

    public static boolean isOWins(String[] GAMEBOARD) {
        return isRowOfOs(GAMEBOARD) || isColOfOs(GAMEBOARD) || isDiagonalOfOs(GAMEBOARD);
    }

    public static boolean movesAvailable(String[] GAMEBOARD) {
        return Arrays.asList(GAMEBOARD).contains("_");
    }

    public static boolean hasNoWinner(String[] GAMEBOARD) {
        return !isXWins(GAMEBOARD) && !isOWins(GAMEBOARD);
    }

    public static int count(String player, String[] GAMEBOARD) {
        int count = 0;
        for (String move : GAMEBOARD) {
            if (move.equals(player)) {
                count++;
            }
        }
        return count;
    }

    public static boolean wrongNumberOfMoves(String[] GAMEBOARD) {
        int movesDiff = count("X", GAMEBOARD) - count("O", GAMEBOARD);
        return movesDiff < -1 || movesDiff > 1;
    }

    public static boolean isDraw(String[] GAMEBOARD) {
        return hasNoWinner(GAMEBOARD) && !movesAvailable(GAMEBOARD);
    }

    public static boolean isNotFinished(String[] GAMEBOARD) {
        return hasNoWinner(GAMEBOARD) && movesAvailable(GAMEBOARD);
    }

    public static boolean isImpossible(String[] GAMEBOARD) {
        return isXWins(GAMEBOARD) && isOWins(GAMEBOARD) || wrongNumberOfMoves(GAMEBOARD);
    }

    public static String[] READGAMEBOARD() {
        System.out.print("Enter cells: ");
        Scanner SCANNER = new Scanner(System.in);
        String line = SCANNER.nextLine();
        return line.strip().split("");
    }

    public static void Board(String[] GAMEBOARD) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", GAMEBOARD[3 * i + j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static String CkeckStatus(String[] gameState) {
        String STATUS = "Unknown game state";

        if (isImpossible(gameState)) {
            STATUS = "Impossible";
        } else if (isNotFinished(gameState)) {
            STATUS = "Game not finished";
        } else if (isXWins(gameState)) {
            STATUS = "X wins";
        } else if (isOWins(gameState)) {
            STATUS = "O wins";
        } else if (isDraw(gameState)) {
            STATUS = "Draw";
        }

        return STATUS;
    }

    public static Coordinates readUserMove() throws OutBoundsMoveException {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt() - 1;
        int x = scanner.nextInt() - 1;
        return new Coordinates(x, y);
    }

    public static void makeUserMove(Coordinates move, String[] gameState) throws OccupiedCoordinateException {
        String target = gameState[move.y * 3 + move.x];

        if (target.equals("X") || target.equals("O")) {
            throw new OccupiedCoordinateException();
        }

        gameState[move.y * 3 + move.x] = "X";
    }


    public static void USERMOVE(String[] GAMEBOARD) {
        try {
            System.out.print("Enter the coordinates: ");
            Coordinates MOVE = readUserMove();
            makeUserMove(MOVE, GAMEBOARD);
        } catch (OutBoundsMoveException e) {
            System.out.println("Coordinates should be from 1 to 3!");
            USERMOVE(GAMEBOARD);
        } catch (OccupiedCoordinateException e) {
            System.out.println("This cell is occupied! Choose another one!");
            USERMOVE(GAMEBOARD);
        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            USERMOVE(GAMEBOARD);
        }
    }

    public static String[] emptyBoard() {
        String[] board = new String[9];
        Arrays.fill(board, " ");
        return board;
    }

    public static void play() {
        String[] gameState = emptyBoard();
        String gameStatus = "";
        String nextPlayer = "X";

        while (gameStatus.equals("Game not finished")) {
            Board(gameState);
             nextPlayer = nextPlayer.equals("X") ? "O" : "X";
        }

        Board(gameState);
        System.out.println(gameStatus);
    }

    public static void main(String[] args) {
        play();
    }
}