public class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        
        int x = 0;
        int y = N - 1;
        int result = Math.min(height[x], height[y]) * (y - x);

        while (true) {
            if (x == y)
                break;
            int minVal = Math.min(height[x], height[y]);
            if (height[x] >= height[y]) {
                while (height[y] <= minVal && y > x) {
                    y--;
                    if (Math.min(height[x], height[y]) * (y - x) > result)
                        result = Math.min(height[x], height[y]) * (y - x);
                }
            } else {
                while (height[x] <= minVal && y > x) {
                    x++;
                    if (Math.min(height[x], height[y]) * (y - x) > result)
                        result = Math.min(height[x], height[y]) * (y - x);
                }
            }
        }
        return result;
    }
}