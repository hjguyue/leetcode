class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1)
            return 0;
        
        int Max[] = new int[len];
        Max[len-1] = prices[len-1];
        for(int i = len-2; i >= 0; i--)
            Max[i] = Math.max(prices[i], Max[i+1]);

        int Min[] = new int[len];
        Min[0] = prices[0];
        for(int i = 1; i < len; i++)
            Min[i] = Math.min(prices[i], Min[i-1]);

        int f[] = new int[len];
        f[len-1] = 0;
        for(int i = len - 2; i >= 0; i--)
            f[i] = Math.max(Max[i+1] - prices[i], f[i+1]);
        
        int g[] = new int[len];
        g[0] = 0;
        for(int i = 1; i < len; i++)
        	g[i] = Math.max(prices[i] - Min[i-1], g[i-1]);
        
        int maxVal = Math.max(g[len-1], f[0]);
        for(int i = 1; i < len-2; i++){
        	if (g[i] + f[i+1] > maxVal) {
        		maxVal = g[i] + f[i+1];
        	}
        }
        // 1 2 3 4 5
        return maxVal;
    }
}