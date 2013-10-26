public class Solution {
    public boolean search(int[] A, int target) {
       	for (int i = 0; i < A.length; i++)
       		if (target == A[i])
       			return true;
       	return false;
    }
}