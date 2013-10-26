public class Solution {
    public void sortColors(int[] A) {
        int N = A.length;
        int start = -1;
        int end = N;

        for (int i = 0; i < N; i++) {
            if (i >= end)
            	break;
            if (A[i] == 1)
                continue;

            while (A[i] != 1 && end > i) {
                if (A[i] == 0) {
                    int temp = A[start + 1];
                    A[start + 1] = 0;
                    A[i] = temp;
                    start++;
                    break;
                }
                else{
					int temp = A[end - 1];
                    A[end - 1] = 2;
                    A[i] = temp;
                    end--;
                }
            }
        }
    }
}