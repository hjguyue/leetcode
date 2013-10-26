public class Solution {
    public int jump(int[] A) {
        int len = A.length;
        int reach[] = new int[len];
        int Max = 0;

        reach[0] = 0;
        for (int i = 0; i < len; i++) {
            if (i + A[i] < Max)
                continue;
            for (int step = Max + 1; step <= (i + A[i]) && step < len; step++)
                reach[step] = reach[i] + 1;
            Max = i + A[i];
        }
        return reach[len - 1];
    }
}