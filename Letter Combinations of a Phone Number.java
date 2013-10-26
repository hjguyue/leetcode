public class Solution {
    
    public ArrayList<String> letterCombinations(String digits) { 
        return f(digits);
    }
    
    String strs[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public ArrayList<String> f(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        if (digits.length() == 0) {
            list.add("");
            return list;
        }

        int id = Integer.parseInt(digits.substring(0,1));
        for (String str : f(digits.substring(1)))
            for (int i = 0; i < strs[id].length(); i++)
                list.add(strs[id].substring(i, i + 1) + str);

        return list;
    }
}