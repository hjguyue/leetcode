public class Solution {

	public boolean isMatch(String s, String p) {
		int lenS = s.length();
		int lenP = p.length();
//		s = s + "#";
//		p = p + "#";

		int i = 0; int prevI = -1;
		int j = 0; int prevJ = -1;
		while(i < lenS){
			if (j < lenP && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++; j++;
				continue;
			}
			if (j < lenP && p.charAt(j) == '*') {
				prevI = i; prevJ = j;
				j++;
				continue;
			}
			if (prevJ == -1)
				return false;
			prevI++;
			i = prevI;
			j = prevJ + 1;
		}
		while (j < lenP && p.charAt(j) == '*'){
			j++;
		}
		return j == lenP;
	}

    // DP:

    public boolean isMatchDP(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        // f[i][j] = f[i+1][j+1] | f[i+1][j]
        boolean f[][] = new boolean[lenS + 1][lenP + 1];

        f[lenS][lenP] = true;
        for (int i = 0; i < lenS; i++)
            f[i][lenP] = false;
        for (int j = lenP - 1; j >= 0; j--)
            f[lenS][j] = (p.substring(j, j + 1).equals("*") && f[lenS][j + 1]);

        for (int i = lenS - 1; i >= 0; i--) {
            for (int j = lenP - 1; j >= 0; j--) {
                if (!p.substring(j, j + 1).equals("*") && !p.substring(j, j + 1).equals("?") && !s.substring(i, i + 1).equals(p.substring(j, j + 1))) {
                    f[i][j] = false;
                    continue;
                }
                f[i][j] = f[i + 1][j + 1];
                if (p.substring(j, j + 1).equals("*"))
                    f[i][j] = f[i][j] | f[i + 1][j] | f[i][j + 1];
            }
        }
        return f[0][0];
    }
}