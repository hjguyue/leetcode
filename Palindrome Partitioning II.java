public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();

        boolean isPalindrome[][] = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
        	for (int j = 0; j < len; j++) {
        		if (i >= j)
        			isPalindrome[i][j] = true;
        		else if (s.substring(i, i + 1).equals(s.substring(j, j + 1))) {
        			isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
        		}
        	}
        }

        int num[] = new int[len + 1];
        num[0] = 0;
        for (int i = 1; i <= len; i++) {
            int MIN = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1])
                    MIN = Math.min(MIN, num[j] + 1);
            }
            num[i] = MIN;
        }
        return num[len] - 1;
    }

}
