public class Solution {
	public String longestPalindrome_dp(String s) {
		int len = s.length();

		// f[m][n] = f[m+1][n-1] ?
		boolean f[][] = new boolean[len][len];
		int maxLen = 1;
		String ans = s.substring(0, 1);
		for (int i = 0; i < len; i++) {
			for (int j = len - 1; j >= 0; j--) {
				if (j >= i) {
					f[j][i] = true;
					continue;
				}
				f[j][i] = (s.substring(j, j + 1).equals(s.substring(i, i + 1)));
				if (i > (j + 1))
					f[j][i] = f[j][i] & f[j + 1][i - 1];

				if ((i - j + 1) >= maxLen && f[j][i]) {
					maxLen = i - j + 1;
					ans = s.substring(j, i + 1);
				}

			}
		}
		return ans;
	}	
}
public class Solution{
	public String longestPalindrome(String s) {
    	if (s.length() == 0)
			return "";
    	
    	StringBuffer buffer = new StringBuffer();
    	for (int i = 0; i < s.length(); i++)
    		buffer.append("#" + s.substring(i,i+1));
    	buffer.append("#");
    	String str = buffer.toString();
    	
    	int len = str.length();
    	int p[] = new int[len];
    	int end = 0;
    	int id = 0;
    	int maxVal = 0;
    	int pos = 0;
    	for(int i = 0; i < len; i++){
    		if (end > i)
    			p[i] = Math.min(p[2 * id - i], end - i + 1);
    		else
    			p[i] = 1;
    		while(true){
    			if (i + p[i] < len && i - p[i] >= 0 && str.substring(i + p[i], i + p[i] + 1).equals(str.substring(i - p[i], i - p[i] + 1)))
					p[i]++;
    			else
					break;
    		}
    		if (i + p[i] > end) {
				end = i + p[i] - 1;
				id = i;
			}
    		if (p[i] > maxVal) {
				maxVal = p[i];
				pos = i;
			}
    	}
    	return str.substring(pos - p[pos] + 1, pos + p[pos]).replaceAll("#", "");
    }
}