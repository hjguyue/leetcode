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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        visit(list, root);
        root.left = null;
        TreeNode node = root;
        for (int i = 1; i < list.size(); i++) {
            node.right = list.get(i);
        	node = node.right;
        	node.left = null;
        }
        node.right = null;
    }

    public void visit(ArrayList<TreeNode> list, TreeNode node){
    	if (node == null)
    		return;
    	
    	list.add(node);
    	visit(list, node.left);
    	visit(list, node.right);
    }
}