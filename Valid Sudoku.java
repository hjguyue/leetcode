class Solution {
    public boolean isValidSudoku(char[][] board) {
        FIND = false;
        fill(board, 0);
        return FIND;
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
        if (board[row][col] == '.') {
            fill(board, K + 1);
        	return;
        }
        if (board[row][col] != '.') {
        	if (safe(board, row, col))
        		fill(board, K + 1);
        }
    }
    

    public boolean safe(char[][] board, int row, int col) {
        for (int k = 0; k < 9; k++) {
            if (k != row && board[k][col] == board[row][col])
                return false;
            if (k != col && board[row][k] == board[row][col])
                return false;
        }
        int r = row / 3;
        int c = col / 3;
        for (int m = 3 * r; m < 3 * r + 3; m ++)
            for (int n = 3 * c; n < 3 * c + 3; n ++)
                if (!(m == row && n == col) && board[m][n] == board[row][col])
                    return false;
        return true;
    }
}