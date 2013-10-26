public class Solution {
    public int[] plusOne(int[] digits) {
		int save = 1;
		int len  = digits.length;
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        for (int i = len - 1; i >= 0; i--) {
        	int value = digits[i] + save;
        	buffer.add(value % 10);
        	save = value / 10;
        }
        if (save == 1)
        	buffer.add(1);
        int ans[] = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
        	ans[i] = buffer.get(buffer.size() - 1 - i);
        }
        return ans;
    }
}