public class Solution {
    public int trap(int[] A) {
        int N = A.length;
        if (N == 0)
            return 0;

        // Max from left, from right:
        int MaxL[] = new int[N];
        int MaxR[] = new int[N];
        MaxL[0] = A[0];
        MaxR[N - 1] = A[N - 1];
        for (int i = 1; i < N; i++)
        	MaxL[i] = Math.max(MaxL[i - 1], A[i]);
        for (int i = N - 2; i >= 0; i--)
        	MaxR[i] = Math.max(MaxR[i + 1], A[i]);

        int sum = 0;
        for (int i = 1; i < N-1; i++)
        	sum += Math.max(0, Math.min(MaxL[i - 1], MaxR[i + 1]) - A[i]);

        return sum;
    }
}