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
    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        if (root == null)
            return res;
        return visit(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean visit(TreeNode node, int low, int top){
    	if (node.val >= top || node.val <= low)
    		return false;
    	if (node.left != null && !visit(node.left, low, node.val))
    		return false;
    	if (node.right != null && !visit(node.right, node.val, top))
    		return false;
    	return true;
    }
}