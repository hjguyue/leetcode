public class Solution {
    public int singleNumber(int[] A) {
        int N = A.length;
        long ans = 0;

        long k = 1;
        for (int i = 0; i <= 20; i++) {
            int remain = 0;
            int remain_1 = 0;
            int remain_2 = 0;
            for (int j = 0; j < N; j++) {
                int temp = A[j] % 3;
                A[j] = A[j] / 3;
                if (temp > 0)
                    remain_1 += temp;
                else
                    remain_2 += temp;
                remain = remain_1 % 3 + remain_2 % 3;
            }
            ans = remain * k + ans;
            k = k * 3;
        }
        return (int)ans;
    }
}