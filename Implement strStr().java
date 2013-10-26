public class Solution {
    public String strStr(String haystack, String needle) {
        int position = haystack.indexOf(needle);
        if(position >= 0)
    		return haystack.substring(position);
    	return null;
    }
}