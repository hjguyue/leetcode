class Solution {
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // f(sum, n) = an + f(sum-an, n-1); 2*an + f(sum - 2*an, n-1) ...
        Arrays.sort(num);
        int n = 0;
        while(num[n] <= target){
            n++;
            if (n == num.length)
                break;
        }
        
        ArrayList<ArrayList<Integer>> f[][] = new ArrayList[target+1][n+1];
        set = new HashSet<String>();
        
        f[0][0] = new ArrayList<ArrayList<Integer>>();
        f[0][0].add(new ArrayList<Integer>());

        for(int sum = 0; sum <= target; sum++){
            for(int remain = 1; remain <= n; remain++){
                ArrayList<ArrayList<Integer>> item = null;
                int id = remain-1;
                // i = 0, 1, 2, 3, 4, ... k
                for(int i = 0; i <= Math.min((sum / num[id]), 1); i++){
                    ArrayList<ArrayList<Integer>> list = f[sum - i * num[id]][remain-1];
                    if (list == null)
                        continue;
                    if (item == null)
                        item = new ArrayList<ArrayList<Integer>>();                     
                    
                    for (ArrayList<Integer> l:list) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.addAll(l);
                        for(int j = 0; j < i; j++)
                            temp.add(num[id]);
                        if (!contains(temp, remain)) {
                            item.add(temp);
                        }
                    }
                }
                f[sum][remain] = item;
            }
        }
        if (f[target][n] == null) 
            f[target][n] = new ArrayList<ArrayList<Integer>>();
        return f[target][n];
    }
    
    HashSet<String> set = new HashSet<String>();
    public boolean contains(ArrayList<Integer> list, int x){
        String str = x + "_";
        for(Integer id:list){
            str += id+"_";
        }
        if (!set.contains(str)) {
            set.add(str);
            return false;
        }
        return true;
    }
}