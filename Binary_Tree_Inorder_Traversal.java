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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        visit(list, root);
        return list;
    }

    public void visit(ArrayList<Integer> list, TreeNode node){
        if (node == null) {
    		return;
    	}
    	visit(list, node.left);
    	list.add(node.val);
    	visit(list, node.right);
    }
}