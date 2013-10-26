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
    public int maxPathSum(TreeNode root) {
        maxVal = -10000000;
        visit(root);
        return maxVal;
    }

    int maxVal;
    public int visit(TreeNode node){
        if (node == null) {
        	return -10000000;
    	}
    	int left  = visit(node.left);
    	int right = visit(node.right);

    	int candidate = Math.max(Math.max(left + node.val, right + node.val), left + right + node.val);
    	candidate = Math.max(Math.max(left, right), candidate);
        candidate = Math.max(candidate, node.val);
    	if( candidate > maxVal) 
    		maxVal = candidate;

    	int returnVal = Math.max(Math.max(left + node.val, right + node.val), node.val);
    	return returnVal;
    }
}