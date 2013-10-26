public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int maxVal = 0;
        HashSet<String> set = new HashSet<String>();
        
        for (int i = 0; i < len; i++) {
            int temp = i;
            set.clear();
            while (true) {
                if (temp == len || set.contains(s.substring(temp, temp + 1))) {
                    temp--;
                    break;
                }
                set.add(s.substring(temp, temp + 1));
                temp ++;
            }
            if (maxVal < (temp - i + 1))
                maxVal = temp - i + 1;
        }
        return maxVal;
    }
}