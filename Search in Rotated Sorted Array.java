public class Solution {
    public int search(int[] A, int target) {
        N = A.length;
        if (N == 0)
            return -1;

        // calculate K:
        int left  = 0;
        int right = N - 1;
        while (right > left) {
            int middle = (left + right) / 2;
            if (A[left] < A[middle])
                left = middle;
            else if (A[left] > A[middle])
                right = middle;
            else if (A[left] == A[middle]) {
				if(A[left] < A[right])
					left = right;
				else
					break;
			}
        }
        K = N - 1 - left;

        // search:
        left = 0;
        right = N - 1;
        while(right > left){
        	int middle = (left + right) / 2;
        	if (A[pos(middle)] < target)
        		left = middle + 1;
        	else if (A[pos(middle)] > target)
        		right = middle - 1;
        	else if (A[pos(middle)] == target)
        		left = right = middle;
        }
        if (A[pos(left)] == target) {
        	return pos(left);
        }
        return -1;
    }

    public static int N;
    public static int K;

    public static int pos(int x){
    	return (x + N - K) % N;
    }

}