 public class Solution {
    public int atoi(String str) {
    	str = str.trim();
    	if (str.length() == 0)
    		return 0;

        int symbol = 1;
        if (str.substring(0,1).equals("-")){
        	symbol = -1;
        	str = str.substring(1);
		}
		if (str.substring(0,1).equals("+")){
        	symbol = 1;
        	str = str.substring(1);
		}

		long num = 0;
		while (str.length() != 0){
			if (!str.substring(0,1).matches("[0-9]"))
				break;
			for (int i = 0; i <= 9; i++) {
				if (str.substring(0, 1).equals("" + i))
					num = num * 10 + i;
			}
			str = str.substring(1);
		}
		if (symbol == -1)
			num = 0 - num;
		if (symbol == 1 && num > Integer.MAX_VALUE)
			num = Integer.MAX_VALUE;
		if (num < Integer.MIN_VALUE)
			num = Integer.MIN_VALUE;
		return (int)num;
    }
}