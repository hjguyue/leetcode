public class Solution {
    public int longestConsecutive(int[] num) {
        int maxLen = 1;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> note = new HashSet<Integer>();
        for (Integer n : num)
            set.add(n);

        for (Integer n : num) {
            if (note.contains(n))
                continue;
            
            int min = n;
            int max = n;
            note.add(n);
            while (set.contains(min - 1)) {
                min--;
                note.add(min);
            }
            while (set.contains(max + 1)) {
                max++;
                note.add(max);
            }
            if (max - min + 1 > maxLen) {
                maxLen = max - min + 1;
            }
        }
        return maxLen;
    }
}