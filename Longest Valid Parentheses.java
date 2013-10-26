public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int maxVal = 0;
        if (len == 0)
            return 0;
        Stack<Entity> stack = new Stack<Entity>();
        for (int i = 0; i < len; i++) {
            String str = s.substring(i, i + 1);
            if (str.equals("(") || stack.size() == 0 || stack.peek().str.equals(")")) {
                stack.push(new Entity(str, i));
            } else {
                stack.pop();
            	int range = i + 1;
            	if (stack.size() != 0)
            		range = i - stack.peek().pos;
                if (range > maxVal)
                    maxVal = range;
            }
        }
        return maxVal;
    }
}

class Entity {
    String str;
    int pos;
    public Entity(String s, int p) {
        str = s;
        pos = p;
    }
}