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
    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        first = null;
        second = null;
        prev = null;
        visit(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    
    public void visit(TreeNode node) {
        if (node == null)
            return;
        
        visit(node.left); 
        
        if (prev != null && prev.val > node.val) {
            if (first == null)
                first = prev;
            second = node;
        }
        prev = node;
        
        visit(node.right);
    }
}