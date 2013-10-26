public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int maxArea = 0;

        for (int i = 0; i < len; i++) {
            if (i > 0 && height[i] == height[i - 1])
                continue;
            int temp = height[i];
            int index = i - 1;
            while (index >= 0 && height[index] >= height[i]) {
                temp += height[i];
                index--;
            }
            index = i + 1;
            while (index < len && height[index] >= height[i]) {
                temp += height[i];
                index++;
            }
            if (temp > maxArea)
                maxArea = temp;
        }
        return maxArea;
    }
}