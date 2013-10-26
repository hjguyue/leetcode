public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenA = s1.length();
    	int lenB = s2.length();
    	int lenC = s3.length();
    	if (lenA + lenB != lenC)
    		return false;

    	boolean f[][] = new boolean[lenA + 1][lenB + 1];
        f[0][0] = true;
        for (int m = 0; m <= lenA; m++) {
    		for (int n = 0; n <= lenB; n++) {
    			if (m ==0 && n == 0)
    				continue;
    			if (m != 0 && s1.substring(lenA - m, lenA - m + 1).equals(s3.substring(lenC - m - n, lenC - m - n + 1)))
    				f[m][n] = f[m][n] | f[m-1][n];
    			if (n != 0 && s2.substring(lenB - n, lenB - n + 1).equals(s3.substring(lenC - m - n, lenC - m - n + 1)))
    				f[m][n] = f[m][n] | f[m][n-1];
    		}
    	}
    	return f[lenA][lenB];
    }
}