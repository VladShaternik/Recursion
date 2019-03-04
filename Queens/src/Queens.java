public class Queens {
    public static void main(String[] args) {

        solveBoard(4);
    }

    public static void solveBoard(int n) {
        int[][] board = new int[n][n];
        solveBoard(board, 0);
    }

    private static boolean solveBoard(int[][] board, int col) {
        printBoard(board);

        // If last column then done
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
     * @param row - row where queen is placed
     * @param col - column where queen is placed
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
        //TODO----------------------------------------------------------------------------------------------------------
        // URGEEEEEEEEEEEEEEEEEEENNTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
        // -------------------------------------------------------------------------------------------------------------
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Lower diagonal
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
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
