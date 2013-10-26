public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int minPath[][] = new int[m][n];
        minPath[m-1][n-1] = grid[m-1][n-1];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
            	if (i == m-1 && j == n-1)
        			continue;
        		if (j == n-1){
        			minPath[i][j] = minPath[i+1][j] + grid[i][j];
        			continue;
        		}
        		if (i == m-1){
        			minPath[i][j] = minPath[i][j+1] + grid[i][j];
        			continue;
        		}
        		minPath[i][j] = Math.min(minPath[i+1][j] + grid[i][j], minPath[i][j+1] + grid[i][j]);
        	}
        }
        return minPath[0][0];
    }
}