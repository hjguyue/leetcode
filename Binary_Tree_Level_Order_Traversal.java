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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> list  = new ArrayList<ArrayList<TreeNode>>();
 
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }

    	ArrayList<TreeNode> cursor = new ArrayList<TreeNode>();
		cursor.add(root);
		list.add(cursor);

		boolean GO_ON = true;
		if (root.left == null && root.right == null)
			GO_ON = false;
		
		while(GO_ON){
			GO_ON = false;
			cursor = new ArrayList<TreeNode>();
			for(TreeNode node:list.get(list.size() - 1)){
				if (node.left != null) {
					GO_ON = true;
					cursor.add(node.left);
				}
				if (node.right != null) {
					GO_ON = true;
					cursor.add(node.right);
				}
			}
            if(cursor.size() > 0)
                list.add(cursor);
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<TreeNode> l:list){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(TreeNode node:l){
				temp.add(node.val);
			}
			result.add(temp);
		}
        return result;
    }
}