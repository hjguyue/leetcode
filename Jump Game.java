public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;
        boolean reach[] = new boolean[len];
        int MAX = 0;

        reach[0] = true;
        for (int i = 0; i < len; i++) {
            if (reach[i] == false)
                continue;
            if (i + A[i] < MAX)
                continue;
            for (int step = MAX; step <= (i + A[i]) && step < len; step++)
                reach[step] = true;
            MAX = i + A[i];
        }
        return reach[len - 1];
    }
}