public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int digit = 1;
        while (10 * digit <= x && (digit < Integer.MAX_VALUE / 10)) {
            digit = 10 * digit;
        }

        while (x > 9) {
            if (x % 10 != x / digit)
                return false;

            x = x - x / digit * digit;
            x = (x - x % 10 ) / 10;
            digit = digit / 100;
        }
        return true;
    }
}