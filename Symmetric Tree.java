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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return visit(root.left, root.right);
    }

    public boolean visit(TreeNode node1, TreeNode node2){
        if (node1 == null || node2 == null) {
    		if (node1 == null && node2 == null)
    			return true;
    		return false;
    	}
        if (node1.val != node2.val)
        	return false;
    	return visit(node1.left, node2.right) & visit(node1.right, node2.left);
    }
}