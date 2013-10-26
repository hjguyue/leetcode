public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1)
    		return 0;
    	
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;

		int num[][] = new int[m + 1][n + 1];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
            	if (obstacleGrid[i][j] == 1)
            		num[i][j] = 0;
            	else if (i == m-1 && j == n-1)
        			num[i][j] = 1;
                else
            		num[i][j] = num[i+1][j] + num[i][j+1];
        	}
        }
        return num[0][0];
    }
}