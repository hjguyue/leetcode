public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        int total = fact(n);
        int buffer = num[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (num[i] == buffer) {
                count ++;
            } else {
            	total /= fact(count);
            	buffer = num[i];
            	count = 1;
            }
        }
        if (count > 1)
        	total /= fact(count);

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while (total > 0) {
            total--;
            ArrayList<Integer> newList = new ArrayList<Integer>();
            nextPermutation(num);
            for (int i = 0; i < n; i++) {
                newList.add(num[i]);
            }
            list.add(newList);
        }
        return list;
    }

    public int fact(int n) {
        int total = 1;
        for (int i = 1; i <= n; i++)
            total *= i;
        return total;
    }

    public void nextPermutation(int[] num) {
        int position = num.length - 1;
        while (true) {
            if (position == 0)
                break;
            if (num[position] > num[position - 1])
                break;
            position--;
        }
        if (position == 0) {
            reverse(num, 0, num.length - 1);
            return;
        }
        reverse(num, position, num.length - 1);
        for (int i = position; i < num.length; i++) {
            if (num[i] > num[position - 1]) {
                int temp = num[position - 1];
                num[position - 1] = num[i];
                num[i] = temp;
                break;
            }
        }
    }

    public void reverse(int[] num, int start, int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            int temp = num[i];
            num[i] = num[start + end - i];
            num[start + end - i] = temp;
        }
    }
}