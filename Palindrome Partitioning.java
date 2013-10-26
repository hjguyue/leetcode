public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        
        if (s == null || s.length() == 0){
            return null;
        }
        int len = s.length();


        ArrayList<ArrayList<ArrayList<String>>> table = new ArrayList<ArrayList<ArrayList<String>>>();
        table.add(new ArrayList<ArrayList<String>>());
        for (int i = 1; i <= len; i++) {
        	ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        	for (int j = 0; j < i; j++) {
        		String substring = s.substring(j,i);
        		if (isPalindrome(substring)){
            		ArrayList<ArrayList<String>> preList = table.get(j);
        			for (ArrayList<String> l: preList) {
        				ArrayList<String> copy = (ArrayList<String>) l.clone();
        				copy.add(substring);
        				list.add(copy);
        			}
        			if (j == 0) {
        				ArrayList<String> l = new ArrayList<String>();
        				l.add(substring);
        				list.add(l);
        			}
        		}
        	}

        	table.add(list);
        }
        return table.get(len);
    }

    public boolean isPalindrome(String str){
    	int len = str.length();
    	for (int i = 0; i < len / 2; i++)
    		if (!str.substring(i,i+1).equals(str.substring(len - 1 - i, len - i)))
    			return false;
    	return true;
    }
}
