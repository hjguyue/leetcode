public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0)
                n1 = 1;
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                n2 = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int k = 1; k < m; k++)
                    matrix[k][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int k = 1; k < n; k++)
                    matrix[i][k] = 0;
            }
        }

        if (n1 == 1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (n2 == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}