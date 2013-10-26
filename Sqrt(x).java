public class Solution {
    public int sqrt(int x) {
		int left  = 0;
		int right = 100000;
		while (left < right - 1){
			int mid = (left + right) / 2;
			if (mid * mid > x || mid * mid < 0)
				right = mid;
			else if (mid * mid <= x)
				left = mid;
		}
		if (right * right <= x && right * right > 0)
			return right;
		
        return left;
    }
}