public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
    		return s;

        int len = s.length();
        int n = nRows;
        int sum = 2 * (n - 1);

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
        	int count = i;
        	while (count < len){
        		buffer.append(s.substring(count, count + 1));

        		int next = count + sum - 2 * i;
        		if (i != 0 && i != n-1 && next < len)
        			buffer.append(s.substring(next, next + 1));
        		
        		count += sum;
        	}
        }
        return buffer.toString();
    }
}