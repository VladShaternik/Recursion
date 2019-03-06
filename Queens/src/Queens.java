/**
 * AUTHOR: VLADYSLAV SHATERNIK
 * CLASS: CS4A
 * PERIOD: MW/8am
 * <p>
 * Place n number of queens on an n x n chessboard so that no queen can attack any other queen.
 * In chess, a queen is a powerful piece that can attack horizontally, vertically, and diagonally.
 * It can move any number of spaces in a single direction. Therefore, a correct solution implies that
 * no two queens will be placed on the same vertical column, horizontal row, or diagonal line.
 */
public class Queens {
    public static void main(String[] args) {
        for (int i = 4; i <= 10; i += 2) {
            System.out.println("\n\n**************************************************");
            System.out.println(i + " x " + i + " board");
            System.out.println("**************************************************");
            solveBoard(i);
        }
    }

    /**
     * Wrapper for the recursive solveBoard
     *
     * @param n - chess board side (n x n)
     */
    public static void solveBoard(int n) {
        int[][] board = new int[n][n];
        if (!solveBoard(board, 0)) {
            System.out.println("***** No solutions *****");
        } else {
            printBoard(board);
        }
    }

    /**
     * Recursive solution to the queen problem of the given board
     *
     * @param board - board to solve
     * @param col   - column where the next move goes
     * @return - wheter the boad is solved
     */
    private static boolean solveBoard(int[][] board, int col) {
        // If last column then done (base case)
        if (col == board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            // if the move is possible then place a queen there
            if (isPossibleMove(board, i, col)) {
                board[i][col] = 1;

                // if smaller board is solved then true ales remove queen and continue
                if (solveBoard(board, col + 1)) {
                    return true;
                } else {
                    board[i][col] = 0;
                }
            }
        }

        return false;
    }

    /**
     * Check whether the queen move is possible
     *
     * @param board - chess board where queen is 1 and empty space is 0
     * @param row   - row where queen is placed
     * @param col   - column where queen is placed
     * @return - whether the queen move is possible
     */
    private static boolean isPossibleMove(int[][] board, int row, int col) {
        int i = 0;
        int j = 0;

        // Left side
        for (; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Upper diagonal
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }

            i--;
            j--;
        }

        // Lower diagonal
        i = row;
        j = col;
        while (j >= 0 && i < board.length) {
            if (board[i][j] == 1) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    /**
     * Prints a chess board in the console with queens.
     *
     * @param board - chess board array. Queens should be represented as 1, empty spaces as 0.
     */
    private static void printBoard(int[][] board) {
        System.out.print("┌");
        for (int i = 0; i < board.length - 1; i++) {
            System.out.print("────┬");
        }
        System.out.println("────┐");

        for (int i = 0; i < board.length - 1; i++) {
            System.out.print("│");
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" ♛  │");
                } else {
                    System.out.print("    │");
                }
            }
            System.out.println();

            System.out.print("├");
            for (int k = 0; k < board.length - 1; k++) {
                System.out.print("────┼");
            }
            System.out.println("────┤");
        }

        System.out.print("│");
        for (int j = 0; j < board.length; j++) {
            if (board[board.length - 1][j] == 1) {
                System.out.print(" ♛  │");
            } else {
                System.out.print("    │");
            }
        }
        System.out.println();

        System.out.print("└");
        for (int i = 0; i < board.length - 1; i++) {
            System.out.print("────┴");
        }
        System.out.println("────┘");
    }
}
