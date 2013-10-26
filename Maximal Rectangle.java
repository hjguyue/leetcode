public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
    		return 0;
    	}

        int M = matrix.length;
        int N = matrix[0].length;

        int down[][] = new int[M][N];
        int right[][] = new int[M][N];

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] == '0')
                    continue;
                down[i][j] = 1;
                right[i][j] = 1;
                if (i < M - 1)
                    down[i][j] += down[i + 1][j];
                if (j < N - 1)
                    right[i][j] += right[i][j + 1];
            }
        }

        int Max = 0;
        for (int i = 0; i < M; i++){
        	for (int j = 0; j < N; j++){
        		if (down[i][j] * right[i][j] <= Max)
        			continue;
        		int minEdge = Integer.MAX_VALUE;
        		int area = 0;
        		for (int k = 1; k <= down[i][j]; k++) {
        			minEdge = Math.min(minEdge, right[i + k - 1][j]);
        			area = k * minEdge;
            		Max = Math.max(Max, area);
        		}
        	}
        }
        return Max;
    }
}
