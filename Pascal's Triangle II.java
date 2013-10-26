public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if (rowIndex == 0)
        	return list;

        for (int i = 1; i <= rowIndex; i++) {
        	result = new ArrayList<Integer>();
        	result.add(1);
        	for (int j = 0; j < list.size()-1; j++) {
        		result.add(list.get(j) + list.get(j+1));
        	}
        	result.add(1);
        	list.clear();
        	list.addAll(result);
        }
        return result;
    }
}