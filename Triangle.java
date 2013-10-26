public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int N = triangle.size();
        
        for (int i = N - 2; i >= 0; i--) {
        	for (int j = 0; j < i + 1; j++) {
        		int temp = triangle.get(i).get(j);
        		temp += Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
        		triangle.get(i).set(j, temp);
        	}
        }
        return triangle.get(0).get(0);
    }
}