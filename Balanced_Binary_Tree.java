/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (visit(root) == -1)
        	return false;
        
        return true;
    }

    public int visit(TreeNode node){
    	if (node == null) {
    		return 0;
    	}
    	int val1 = visit(node.left);
    	int val2 = visit(node.right);
    	if (val1 == -1 || val2 == -1 || Math.abs(val2 - val1) > 1) 
    		return -1;
    	
    	return Math.max(val1, val2) + 1;
    }
}