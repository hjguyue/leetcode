public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int x = y = 0;
        int k = 1;
        int direct = 0;
        while (k <= n * n) {
            matrix[x][y] = k++;
            while (k <= n*n) {
                if (direct == 0 && y + 1 < n && matrix[x][y + 1] == 0) {y++; break; } 
                if (direct == 1 && x + 1 < n && matrix[x + 1][y] == 0) {x++; break; }
                if (direct == 2 && y - 1 >= 0 && matrix[x][y - 1] == 0) {y--; break; }
                if (direct == 3 && x - 1 >= 0 && matrix[x - 1][y] == 0) {x--; break; } 
                direct = (direct+1) % 4;
            }
        }
        return matrix;
    }
}