public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int size_S = S.length();
        int size_L = L.length;
        int len = L[0].length();

        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        for (int i = 0; i < size_L; i++) {
            if (!map.containsKey(L[i]))
                map.put(L[i],0);
            map.put(L[i], map.get(L[i]) + 1);
        }
        OUTER:
        for (int i = 0; i < size_S - len * size_L + 1; i++) {
            String str = S.substring(i, i + len * size_L);
            temp.clear();
            temp.putAll(map);

            for (int j = 0; j < size_L; j++) {
                String substr = str.substring(j * len, j * len + len);
                if (!temp.containsKey(substr)) {
                    continue OUTER;
                }
                temp.put(substr, temp.get(substr) - 1);
                if (temp.get(substr) == 0)
                	temp.remove(substr);
            }
            if (temp.size() == 0) {
                list.add(i);
            }
        }
        return list;

    }
}