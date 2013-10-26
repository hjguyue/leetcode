public class Solution {
    public int totalNQueens(int n) {
    	N = n;
    	sum = 0;
    	sRow = new int[n];
    	sCol = new int[n];
    	dRow = new int[2 * n];
    	dCol = new int[2 * n];
    	ans = new int[n];
    	func(0);
    	
    	return sum;
    }

    int N;
    int sum;
    int sRow[];
    int sCol[];
    int dRow[];
    int dCol[];
    int ans[];
    
    public boolean safe(int row, int col){
    	if (sRow[row] == 0 && sCol[col] == 0 && dRow[row + col] == 0 && dCol[row - col + N - 1] == 0)
			return true;
    	return false;
    }

    public void func(int row){
    	if (row == N) {
    		sum++;
			return;
		}
    	for(int col = 0; col < N; col++){
    		if (!safe(row, col))
    			continue;
    		ans[row] = col;
    		sRow[row] = 1;
    		sCol[col] = 1;
    		dRow[row + col] = 1;
    		dCol[row - col + N - 1] = 1;
    		func(row + 1);
    		sRow[row] = 0;
    		sCol[col] = 0;
    		dRow[row + col] = 0;
    		dCol[row - col + N - 1] = 0;
    	}
    }
}