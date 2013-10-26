public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int k = 1 << n;

        for(int i = 0; i < k; i++){
        	ArrayList<Integer> l = new ArrayList<Integer>();
        	int num = i;
        	int count = 0;
        	int total = 0;
        	while(count <= n){
        		count ++;
        		if (num % 2 == 1) {
        			l.add(count);
        			total++;
        		}
        		num >> 1;
        	}
        	if (total == k) {
        		list.add(l);
        	}
        }
        return list;
    }
}