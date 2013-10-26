public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        note = new int[10000];
        val  = new int[10000];
        note[0] = 1;
        val[0] = 1;
        return decode(s);
    }

    int note[];
    int val[];
    public int decode(String str){
    	int result;
    	if (note[str.length()] == 1)
    		return val[str.length()];
    	
        if (str.length() == 1 && !str.substring(0,1).equals("0"))
    		return 1;

    	String first = str.substring(0,1);
    	if (first.equals("0")) {
    		return 0;
    	}

    	String second = str.substring(1,2);

    	int number = Integer.parseInt(first + second);
    	if (number <= 26)
    		result = decode(str.substring(1)) + decode(str.substring(2));
    	else
 		   	result = decode(str.substring(1));
 		
		note[str.length()] = 1;
		val[str.length()] = result;
		return result;
    }
}