public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        int len = num.length;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < (1 << len); i++) {
            int temp = i;
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int j = 0; j < len; j++) {
        		if (temp % 2 == 1)
        			newList.add(num[j]);
        		temp = temp / 2;
        	}
        	list.add(newList);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashSet<String> set = new HashSet<String>();
        for (ArrayList<Integer> l:list) {
        	if (!set.contains(toStr(l))) {
        		ans.add(l);
        		set.add(toStr(l));
        	}
        }
        return ans;
    }

    public String toStr(ArrayList<Integer> list){
    	String str = "";
    	for(Integer i:list)
    		str += i + str;
    	return str;
    }
}