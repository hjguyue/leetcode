public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int val[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++)
            val[i][0] = i;
        for (int i = 0; i <= len2; i++)
        	val[0][i] = i;

        for (int i = 1; i <= len1; i++) {
        	for (int j = 1; j <= len2; j++) {
        		int temp = val[i-1][j-1];
        		if (!word1.substring(i-1,i).equals(word2.substring(j-1,j)))
        			temp++;
        		val[i][j] = Math.min(val[i - 1][j] + 1, val[i][j - 1] + 1);
        		val[i][j] = Math.min(temp, val[i][j]);
        	}
        }

        return val[len1][len2];
    }
}