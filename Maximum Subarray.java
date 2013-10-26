public class Solution {
    public int maxSubArray(int[] A) {
        int maxVal = A[0];
    	for (int i = 1; i < A.length; i++) {
    		if (A[i] < A[i] + A[i-1])
    			A[i] = A[i] + A[i-1];
    		if (A[i] > maxVal)
    			maxVal = A[i];
    	}
    	return maxVal;
    }
}