public class Solution {
    public void solveSudoku(char[][] board) {
    	FIND = false;
        fill(board, 0);
    }

    public static int offset = 48;
    public static boolean FIND;

    public void fill(char[][] board, int K) {
        if (K == 81 || FIND) {
        	FIND = true;
            return;
        }

        int row = K / 9;
        int col = K % 9;
        if (board[row][col] != '.') {
            fill(board, K + 1);
            return;
        }

        OUTER:
        for (int i = 1; i <= 9; i++) {
            board[row][col] = (char)(offset + i);
            for (int k = 0; k < 9; k++) {
                if (k != row && board[k][col] == board[row][col])
                    continue OUTER;
                if (k != col && board[row][k] == board[row][col])
                    continue OUTER;
            }
            int r = row / 3;
            int c = col / 3;
            for (int m = 3 * r; m < 3 * r + 3; m ++)
                for (int n = 3 * c; n < 3 * c + 3; n ++)
                    if (!(m == row && n == col) && board[m][n] == board[row][col])
                        continue OUTER;

            fill(board, K + 1);
            if (FIND)
            	return;
        }
        board[row][col] = '.';
    }
}