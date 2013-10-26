public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = generate(s, 4);
        return result;
    }

    public ArrayList<String> generate(String s, int k){
    	ArrayList<String> list = new ArrayList<String>();
    	if (k == 0) {
    		if (s.length() == 0)
    			list.add("");
			return list;
    	}
    	k--;
    	for (int i = 1; i < Math.min(4, s.length()+1); i++) {
    		String first = s.substring(0,i);
    		if (Integer.parseInt(first) > 255)
    			continue;
    		if (first.substring(0,1).equals("0") && first.length() > 1)
    			continue;
    		ArrayList<String> subList = generate(s.substring(i),k);
    		if (subList.size() > 0) {
    			for (String str:subList) {
    				String newStr = first + "." + str;
    				if (k == 3)
						newStr = newStr.substring(0, newStr.length()-1);
        			list.add(newStr);
        		}
			}
    	}
    	return list;
    }
}