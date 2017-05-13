/**
 * Created by Audrey on 5/7/2017.
 */
public class TicTacToeBoard {
    static int colSize = 3;
    static int rowSize = 3;
    char[][] board = new char[rowSize][colSize];

    public TicTacToeBoard() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                board[i][j] = '\0';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rowSize; i++ ) {
            for (int j = 0; j < colSize; j++) {
                System.out.print("  ");
                if (board[i][j] == '\0') {
                    System.out.print(" ");
                }
                else {
                    System.out.print(board[i][j]);
                }
                if (j == colSize - 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("  |");
                }
            }
            System.out.println();
            if (i == rowSize - 1) {
                System.out.println();
            }
            else {
                System.out.println("-----------------");
            }
        }
    }


        public int checkValidInput(int row, int col, boolean player)
        {
            for(int r = 0; r < board.length; r++)
            {
                for(int c = 0; c < board[r].length; c++)
                {
                    if( row >= 0 && row < rowSize && col >= 0 && col < colSize)
                    {
                        if(board[row][col] == '\0')
                        {
                            if(player == true)
                            {
                                board[row][col] = 'X';
                                return 0;
                            }
                            else
                            {
                                board[row][col] = 'O';
                                return 0;
                            }
                        }
                        else
                        {
                            System.out.println( " Invalid Input: spot already taken ");
                            return -1;
                        }
                    }
                    else
                    {
                        System.out.println(" Invalid Input: Out of bounds ");
                        return -1;
                    }

                }
            }

            return 0;
        }

        //check for win or draw
        public int checkWin(int row, int col, boolean player) {
            /* int count = 0;
            char playerLetter;
            if (player == true) {
                playerLetter = 'X';
            } else {
                playerLetter = 'O';
            }

            for (int i = 0; i < board.length; i++) {
                if (board[i][i] == 'X' || board[i][i] == 'O') {
                    count++;
                }
            }
            if (count == 3) {
                System.out.print("Player " + playerLetter + " wins! ");
                return 0;
            } else {
                return 1;
            }*/
            int count = 0;
            char playerLetter;

            if (player == true) {
                playerLetter = 'X';
            } else {
                playerLetter = 'O';
            }

            //check rows for win
            for (int r = 0; r < rowSize && count < 3; r++) {
                for (int c = 0; c < colSize; c++) {
                    if (board[r][c] == playerLetter) {
                        count++;
                    }
                    else {
                        count = 0;
                        break;
                    }
                }
            }

            if (count < 3) {
                count = 0;

                //check cols for win
                for (int c = 0; c < colSize && count < 3; c++) {
                    for (int r = 0; r < rowSize; r++) {
                        if (board[r][c] == playerLetter) {
                            count++;
                        }
                        else {
                            count = 0;
                            break;
                        }
                    }
                }
            }

            if (count < 3) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][i] == playerLetter) {
                        count++;
                    }
                    else {
                        count = 0;
                        break;
                    }
                }
            }

            if (count < 3) {
                int j = 2;
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == playerLetter) {
                        count++;
                        j--;
                    }
                    else {
                        count = 0;
                        break;
                    }
                }
            }


            //set win condition
            if (count == 3) {
                System.out.println("Player " + playerLetter + " wins! ");
                return 0;
            } else {
                return 1;
            }
        }
}
