public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;

        int len = A.length;
        int buffer = A[0];
        int count = 0;
        int pos = 1;

        for (int i = 1; i < A.length; i++) {
            if (buffer == A[i] && count == 1)
            	continue;
            
            if (buffer == A[i] && count == 0) {
            	count = 1;
				A[pos] = A[i];
				pos++;
				continue;
            }
            
            count = 0;
            buffer = A[i];
            A[pos] = A[i];
            pos++;
        }
        return pos;
    }
}