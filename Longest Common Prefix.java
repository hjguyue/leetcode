public class Solution {
    public String longestCommonPrefix(String[] strs) {        
        String result = "";
        if(strs.length == 0)
            return result;

    	int minLen = strs[0].length();
    	for (int i = 0; i < strs.length; i++)
    		minLen = Math.min(minLen, strs[i].length());

    	String temp = "";
    	for (int i = 0; i < minLen; i++) {
    		for (int id = 0; id < strs.length; id++) {
    			if (!strs[id].substring(i, i + 1).equals(strs[0].substring(i, i+1)))
    				return result;
    		}
    		result += strs[0].substring(i, i+1);
    	}
    	return result;
    }
}