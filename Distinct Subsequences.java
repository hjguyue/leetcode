public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int f[][] = new int[m+1][n+1];

        for (int i = 0; i <= m; i++)
            f[i][0] = 1;
        for (int i = 1; i <= n; i++)
            f[0][i] = 0;
    	
    	for (int i = 1; i <= m; i++){
    		for (int j = 1; j <= n; j++) {
    			f[i][j] = f[i-1][j];
    			if (S.substring(i-1,i).equals(T.substring(j-1,j)))
    				f[i][j] += f[i-1][j-1];
    		}
    	}
    	return f[m][n];
    }
}