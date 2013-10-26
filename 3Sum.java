public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;

        Arrays.sort(num);
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a:num){
            set.add(a);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();


        if(len <= 2)
            return list;
        
        int tempI = 0;
        int tempJ = 0;
        for(int i = 0; i < len-2; i++){
            if(i != 0 && tempI == num[i])
                continue;
            else
                tempI = num[i];
            for(int j = i+1; j < len-1; j++){
                if(j != 1 && tempJ == num[j])
                    continue;
                else
                    tempJ = num[j];
                    
                if(-(num[i] + num[j]) >= num[j+1] && set.contains(-(num[i] + num[j]))){
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(-(num[i] + num[j]));
                    list.add(l);
                }
            }
        }
        return list;
        
    }
}