public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;

        for (int i = 0; i < len; i++) {
    		if (A[i] > len || A[i] <= 0)
    			continue;

    		int position = A[i]-1;
    		while(true){
    			if (A[position] == (position + 1))
    				break;
    			
    			if (A[position] > len || A[position] <= 0) {
    				A[position] = position + 1;
    				break;
    			}
    			int temp = A[position];
    			A[position] = position + 1;
                position = temp - 1;
    		}
    	}

    	for(int i = 0; i < len; i++)
    		if (A[i] != (i+1)) {
    			return (i+1);
    		}
        return len+1;
    }
}