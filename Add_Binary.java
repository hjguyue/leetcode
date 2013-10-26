public class Solution {
    public String addBinary(String a, String b) {
        // make sure len_a < len_b
    	if (a.length() > b.length()) {
    		String tempStr = a;
    		a = b;
    		b = tempStr;
    	}
    	int len = a.length();
    	while(len < b.length()){
    		a = "0" + a;
    		len++;
    	}
    	
    	int save = 0;
    	String result = "";
        for (int i = b.length()-1; i >= 0; i--) {
        	int x = Integer.parseInt(a.substring(i,i+1));
        	int y = Integer.parseInt(b.substring(i,i+1));
            int val = x + y + save;
        	result = (val % 2) + "" + result;
        	save = val / 2;
        }
        if(save == 1){
            result = "1" + result;
        }
        return result;
    }
}