public class Solution {
    public int maxProfit(int[] prices) {
        // a1 a2 a3 a4
        // f(k) = max{f(k+1), Max[k+1]-prices[k]}
        int len = prices.length;
        if(len <= 1)
            return 0;
        
        int Max[] = new int[len];
        Max[len-1] = prices[len-1];
        for(int i = len-2; i >= 0; i--)
            Max[i] = Math.max(prices[i], Max[i+1]);

        int f[] = new int[len];
        f[len-1] = 0;
        for(int i = len - 2; i >= 0; i--)
        	f[i] = Math.max(Max[i+1] - prices[i], f[i+1]);
        
        return f[0];
    }
}