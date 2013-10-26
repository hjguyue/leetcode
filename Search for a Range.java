public class Solution {
    public int[] searchRange(int[] A, int target) {
        int N = A.length;
        int start = 0;
        int end   = N - 1;
        int[] range = new int[2];

        while (end > start) {
            int middle = (start + end) / 2;
            if (target > A[middle])
                start = middle + 1;
            if (target < A[middle])
                end = middle - 1;
            if (target == A[middle])
                end = middle;
        }
        range[0] = end;

        start = 0;
        end = N - 1;
        while (end > start) {
            int middle = (start + end + 1) / 2;
            if (target > A[middle])
                start = middle;
            if (target < A[middle])
                end = middle - 1;
            if (target == A[middle])
                start = middle;
        }
        range[1] = start;

        if (A[start] != target) {
            range[0] = -1;
            range[1] = -1;
        }
        return range;
    }
}