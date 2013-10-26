public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for (int i = 0; i <= (n-2) / 2; i++) {
            for (int j = 0; j <= (n-1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }

    }
}