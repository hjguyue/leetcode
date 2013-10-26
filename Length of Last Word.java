public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == s.replaceAll(" ","").length())
         	return s.length();
    	
        while(s.length() > 0 && s.substring(s.length()-1, s.length()).equals(" ")){
    		s = s.substring(0, s.length()-1);
    	}
    	
    	int position = s.lastIndexOf(" ");
        return s.length() - position - 1;
    }
}