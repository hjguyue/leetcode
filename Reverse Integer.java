public class Solution {
    public int reverse(int x) {
        if (x == 0)
    		return 0;
    	
    	int num = Math.abs(x);
        String numStr = num + "";

        // while (numStr.substring(numStr.length() - 1).equals("0")){
        // 	numStr = numStr.substring(0, numStr.length() - 1);
        // }

        String ans = "";
        for (int i = 0; i < numStr.length(); i++) {
        	ans = numStr.substring(i, i+1) + ans;
        }
        if (x < 0)
        	ans = "-" + ans;
        return Integer.parseInt(ans);
    }
}