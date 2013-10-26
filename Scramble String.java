public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        
        int n = s1.length();
        if (n <= 1)
            return s1.equals(s2);
        boolean ans = false;
        for(int k = 1; k < n; k++){
        	if (sameAfterSort(s1.substring(0,k), s2.substring(0, k)) && sameAfterSort(s1.substring(k), s2.substring(k)))
        		ans = ans ||(isScramble(s1.substring(0,k), s2.substring(0, k)) && isScramble(s1.substring(k), s2.substring(k)));
			if (sameAfterSort(s1.substring(0,k), s2.substring(n - k)) && sameAfterSort(s1.substring(k), s2.substring(0, n - k)))
        		ans = ans || (isScramble(s1.substring(0,k), s2.substring(n - k)) && isScramble(s1.substring(k), s2.substring(0, n - k)));
        }
        return ans;
    }

    public boolean sameAfterSort(String s1, String s2){
    	char c1[] = s1.toCharArray();
    	char c2[] = s2.toCharArray();

    	Arrays.sort(c1);
    	Arrays.sort(c2);
    	String temp1 = new String(c1);
    	String temp2 = new String(c2);

    	return temp1.equals(temp2);
    }
}