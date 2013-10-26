public class Solution {
    public int removeElement(int[] A, int elem) {
    	int len = A.length;
    	int pointer = 0;
        for (int i = 0; i < len; i++) {
        	if (A[i] == elem)
        		continue;
        	A[pointer] = A[i];
        	pointer++;
        }
        return pointer;
    }
}