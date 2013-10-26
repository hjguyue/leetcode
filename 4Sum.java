public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        int len = num.length;

        Arrays.sort(num);
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a:num){
            set.add(a);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();


        if(len <= 3)
            return list;
        
        for(int i = 0; i < len-3; i++){
            if(i > 0 && num[i] == num[i-1])
                continue;

            for(int j = i+1; j < len-2; j++){
                if(j > i+1 && num[j] == num[j-1])
                    continue;
                
                for (int k = j+1; k < len-1; k++) {
                    if (k > j+1 && num[k] == num[k-1])
                        continue;
                    
                    int res = target - num[i] - num[j] - num[k];
                    if(res >= num[k+1] && set.contains(res)){
                        ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(num[i]);
                        l.add(num[j]);
                        l.add(num[k]);
                        l.add(res);
                        list.add(l);
                    }
                }


            }
        }
        return list;
        
    }
}