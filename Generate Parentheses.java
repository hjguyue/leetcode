public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        n = 2 * n;
        ArrayList<String> f[] = new ArrayList[n + 1];
        f[0] = new ArrayList<String>();
        f[0].add("");

        for (int k = 2; k <= n; k += 2) {
            ArrayList<String> list = new ArrayList<String>();
            for (int end = 2; end <= k; end += 2)
                for (String left : f[end - 2])
                    for (String right : f[k - end])
                        list.add("(" + left + ")" + right);
            f[k] = list;
        }
        return f[n];
    }
}