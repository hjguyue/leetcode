public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> list = new ArrayList<String>();
        if (words.length == 0)
            return list;
        if (L == 0) {
            list.add("");
            return list;
        }

        // initialize:
        String spaces[] = new String[L + 1];
        spaces[0] = "";
        for (int i = 1; i < spaces.length; i++) {
            spaces[i] = spaces[i - 1] + " ";
        }
        // justify:
        int buffer = -1;
        int start  = 0;
        int end    = 0;
        while (end < words.length) {
            if (buffer + words[end].length() + 1 <= L) {
                buffer += words[end].length() + 1;
                end++;
                if (end != words.length)
                    continue;
            }
            int len = 0;
            for (int i = start; i < end; i++)
                len += words[i].length();

            int averLen = L - len;
            int notEven = 0;
            if (start + 1 < end) {
                averLen = (L - len) / (end - start - 1);
                notEven = (L - len) - averLen * (end - start - 1);
            }

            String line = words[start];
            for (int i = start + 1; i < end; i++) {
                if (i <= start + notEven)
                    line += spaces[1];
                line += spaces[averLen] + words[i];
            }
            if (start + 1 == end)
                line += spaces[L - words[start].length()];
            list.add(line);

            start = end;
            buffer = -1;
        }
        // justify the last line:
        int size = list.size();
        while (list.get(size - 1).contains("  ")) {
            list.set(size - 1, list.get(size - 1).replaceAll("  ", " "));
        }
        list.set(size - 1, list.get(size - 1) + spaces[L - list.get(size - 1).length()]);
        return list;
    }
}