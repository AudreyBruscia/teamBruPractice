/* Author: Audrey Bruscia
   Date: 5-7-17
   Description: Driver for tic tac toe game
 */
import java.util.Scanner;

public class TicTacToeDriver {


    public static void main(String args[]) {
        boolean isPlayerX = true;
        int keepGoing = 1;
        char playerLetter;
        int rowChoice;
        int colChoice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to tic tac toe!");

        TicTacToeBoard board = new TicTacToeBoard();

        board.printBoard();

        while (keepGoing == 1) {
            if (isPlayerX) {
                playerLetter = 'X';
            }
            else {
                playerLetter = 'O';
            }
            System.out.println("Player " + playerLetter + " enter row");
            rowChoice = scanner.nextInt();
            System.out.println("Player " + playerLetter + " enter column");
            colChoice = scanner.nextInt();

            if (board.checkValidInput(rowChoice, colChoice, isPlayerX) > -1) {
                keepGoing = board.checkWin(rowChoice, colChoice, isPlayerX);
                isPlayerX = !isPlayerX;
            }

            board.printBoard();

            //keepGoing = 0;
        }
    }


}