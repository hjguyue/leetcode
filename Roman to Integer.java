public class Solution {
    String letters[] = {"I","V","X","L","C","D","M","IV","IX","XL","XC","CD","CM"};
    int nums[] = {1,5,10,50,100,500,1000,4,9,40,90,400,900};

    public int romanToInt(String s) {
        int N = letters.length;
    	int sum = 0;
    	while (s.length() > 0){
    		for (int i = N - 1; i >= 0; i--) {
    			String first = letters[i];
    			if(s.indexOf(first) == 0){
    				sum += nums[i];
    				s = s.substring(first.length());
    				break;
    			}
    		}
    	}   
    	return sum;
    }
}