public class Solution {
    public String countAndSay(int n) {
    	String str[] = new String[n];
    	str[0] = "1";

    	for(int i = 1; i < n; i++){
    		String string = str[i-1];
    		String cursor = string.substring(0,1);
    		str[i] = "";

    		int count = 1;
    		for(int j = 1; j < string.length(); j++){
    			if (string.substring(j,j+1).equals(cursor)) {
    				count++;
    				continue;
    			}
    			str[i] += count + "" + cursor;
    			cursor = string.substring(j,j+1);
    			count = 1;
    		}
    		str[i] += count + "" + cursor;
    	}
    	return str[n-1];
    }
}