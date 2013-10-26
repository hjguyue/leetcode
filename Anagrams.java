import java.util.*;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Vector<Integer>> map = new HashMap<String, Vector<Integer>>();

    	for (int k = 0; k < strs.length; k++) {
    		TreeMap<String, Integer> freqMap = new TreeMap<String, Integer>();
            
    		for(int i = 0; i < strs[k].length(); i++){
    			String subStr = strs[k].substring(i, i+1);
    			if (!freqMap.containsKey(subStr))
    				freqMap.put(subStr, 0);
    			freqMap.put(subStr, freqMap.get(subStr)+1);
    		}

    		String signature = "";
    		for(String str:freqMap.keySet())
    			signature += str + freqMap.get(str);
    		
    		if (!map.containsKey(signature)) 
    			map.put(signature, new Vector<Integer>());
    		map.get(signature).add(k);
    	}

    	for (String str:map.keySet()){
    		if (map.get(str).size() > 1){
    			for(Integer id:map.get(str)){
    				list.add(strs[id]);
    			}
    		}
    	}

        return list;
    }
}