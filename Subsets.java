public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int len = S.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < (1 << len); i++) {
            int temp = i;
        	ArrayList<Integer> newList = new ArrayList<Integer>();
        	for (int j = 0; j < len; j++) {
        		if (temp % 2 == 1)
        			newList.add(S[j]);
        		temp = temp / 2;
        	}
        	list.add(newList);
        }
        return list;
    }
}