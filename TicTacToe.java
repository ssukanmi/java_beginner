import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

        printGameBoard(gameBoard);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter you placement (1-9): ");
            int playerPos = scanner.nextInt();
            placeCharacter(gameBoard, playerPos, "player");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            placeCharacter(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static void placeCharacter(char[][] gameBoard, int pos, String user) {
        char userChar = ' ';

        if (user.equals("cpu")) {
            userChar = 'O';
        } else if (user.equals("player")) {
            userChar = 'X';
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = userChar;
                break;
            case 2:
                gameBoard[0][2] = userChar;
                break;
            case 3:
                gameBoard[0][4] = userChar;
                break;
            case 4:
                gameBoard[2][0] = userChar;
                break;
            case 5:
                gameBoard[2][2] = userChar;
                break;
            case 6:
                gameBoard[2][4] = userChar;
                break;
            case 7:
                gameBoard[4][0] = userChar;
                break;
            case 8:
                gameBoard[4][2] = userChar;
                break;
            case 9:
                gameBoard[4][4] = userChar;
                break;

            default:
                break;
        }
    }

}
