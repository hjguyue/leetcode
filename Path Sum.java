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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return visit(root, sum);
    }

    public boolean visit(TreeNode node, int sum) {
        if (node == null)
            return false;
        if(node.left == null && node.right == null)
            return node.val == sum;
        return visit(node.right, sum - node.val) | visit(node.left, sum - node.val);
    }
}