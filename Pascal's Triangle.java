public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (numRows == 0) {
            return result;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);

        for (int i = 2; i <= numRows; i++) {
        	list = new ArrayList<Integer>();
        	list.add(1);
        	for (int j = 0; j < result.get(i-2).size()-1; j++) {
        		list.add(result.get(i-2).get(j) + result.get(i-2).get(j+1));
        	}
        	list.add(1);
        	result.add(list);
        }
        return result;
    }
}