public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
        	return 0;
        
        int len = A.length;
        int buffer = A[0];
        int pos = 1;

        for (int i = 1; i < A.length; i++) {
        	if (buffer == A[i])
        		continue;
        	buffer = A[i];
        	A[pos] = A[i];
        	pos++;
        }
        return pos;
    }
}