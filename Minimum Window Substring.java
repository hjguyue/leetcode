public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> maps = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapt = new HashMap<Character, Integer>();

        for (int i= 0; i < T.length(); i++) {
            if (!mapt.containsKey(T.charAt(i)))
                mapt.put(T.charAt(i),0);
            mapt.put(T.charAt(i), mapt.get(T.charAt(i)) + 1);
        }

        HashSet<Character> set = new HashSet<Character>();
        String ans = "";
        int start = 0;
        int end = -1;
        while (end < S.length()-1){
            end++;
            char nextS = S.charAt(end);
            if (!mapt.containsKey(nextS))
                continue;
            
            if (!maps.containsKey(nextS))
                maps.put(nextS, 0);
            maps.put(nextS, maps.get(nextS) + 1);
            
            if (maps.get(nextS).intValue() < mapt.get(nextS).intValue())
                continue;
            if (maps.get(nextS).intValue() == mapt.get(nextS).intValue())
                set.add(nextS);
            // move start:
            while (true){
                char prevS = S.charAt(start);
                if (mapt.containsKey(prevS)){
                    if(maps.get(prevS) <= mapt.get(prevS)) 
                        break;
                    maps.put(prevS, maps.get(prevS) - 1);
                }
                start++;
            }
            // update ans:
            if (set.size() == mapt.size())
                if (ans.length() == 0 || ans.length() > (end - start + 1))
                    ans = S.substring(start,end+1);
        }
        return ans;
    }
}