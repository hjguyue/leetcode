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
    public int maxDepth(TreeNode root) {
        return visit(root);
    }

    public int visit(TreeNode node){
        if (node == null)
    		return 0;
    	int left = visit(node.left);
    	int right = visit(node.right);
    	return Math.max(left+1, right+1);
    }
}