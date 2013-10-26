public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        int left = 0;
        int right = len - 1;

        while (left <= right){
            int middle = (left + right) / 2;
        	if (A[middle] < target) {
        		left = middle + 1;
        	}
        	else if (A[middle] > target) {
        		right = middle - 1;
        	}
        	else
        		return middle;
        }
        return left;
    }
}