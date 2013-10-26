public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int x = 0;
        int y = s.length()-1;
        s = s.toLowerCase();
        while (true){
            while (x < s.length() && !valid(s.substring(x, x+1)))
        		x++;
        	while (y >= 0 && !valid(s.substring(y, y+1)))
        		y--;
        	if (x >= y)
        		return true;
        	if (!s.substring(x, x+1).equals(s.substring(y, y+1)))
        		return false;
        	x++; y--;
        }
    }

    public boolean valid(String s){
    	return s.matches("[a-z0-9]");
    }
}


public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
      
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        s = s.toLowerCase();
        int i = 0;
        int j = len -1;
        while(true){
            
            while(i < len && !valid(s.substring(i,i+1)))
                i++;
            while(j>= 0 && !valid(s.substring(j,j+1)))
                j--;
            if(i >= j)
                return true;
            if(!s.substring(i,i+1).equals(s.substring(j,j+1)))
                return false;
            i++; j--;
        }   
    }


    public boolean valid(String s){
        return s.matches("[a-z0-9]");
    }
}