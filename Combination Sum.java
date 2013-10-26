class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // f(sum, n) = an + f(sum-an, n-1); 2*an + f(sum - 2*an, n-1) ...
        Arrays.sort(candidates);
        int n = candidates.length;
        ArrayList<ArrayList<Integer>> f[][] = new ArrayList[target+1][n+1];

        f[0][0] = new ArrayList<ArrayList<Integer>>();
        f[0][0].add(new ArrayList<Integer>());

        for(int sum = 0; sum <= target; sum++){
        	for(int remain = 1; remain <= n; remain++){
        		ArrayList<ArrayList<Integer>> item = null;
        		int id = remain-1;
        		// i = 0, 1, 2, 3, 4, ... k
        		for(int i = 0; i <= (sum / candidates[id]); i++){
        			ArrayList<ArrayList<Integer>> list = f[sum - i * candidates[id]][remain-1];
        			if (list == null)
						continue;
					if (item == null)
                        item = new ArrayList<ArrayList<Integer>>();

					for (ArrayList<Integer> l:list) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.addAll(l);
						for(int j = 0; j < i; j++)
							temp.add(candidates[id]);
						item.add(temp);
					}
        		}
        		f[sum][remain] = item;
        	}
        }
        if (f[target][n] == null) 
            f[target][n] = new ArrayList<ArrayList<Integer>>();
        return f[target][n];
    }
}