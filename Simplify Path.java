public class Solution {
    public String simplifyPath(String path) {
        String strs[] = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].equals(""))
        		continue;
        	if (strs[i].equals("..")) {
        		if (stack.size() > 0)
        			stack.pop();
        		continue;
        	}
        	stack.push(strs[i]);
        }

        String result = "";
        while(stack.size() > 0){
        	result = "/" + stack.pop() + result;
        }
        if (result.equals(""))
        	result = "/";
        return result;
    }
}