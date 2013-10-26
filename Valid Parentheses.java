public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<String> stack = new Stack<String>();
        HashSet<String> set = new HashSet<String>();
        set.add("(");
        set.add("{");
        set.add("[");
        HashSet<String> set2 = new HashSet<String>();
        set2.add("()");
        set2.add("{}");
        set2.add("[]");

        if (len > 0)
            stack.push(s.substring(0, 1));
        for (int i = 1; i < len; i++) {
            String first = s.substring(i,i+1);
            if (stack.size() == 0 || set.contains(first)) {
                stack.push(first);
                continue;
            }
            if (!set2.contains(stack.peek() + first))
                return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}