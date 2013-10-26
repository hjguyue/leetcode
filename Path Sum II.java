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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        list = new ArrayList<ArrayList<Integer>>();
        temp = new ArrayList<Integer>();

        if (root == null)
            return list;

        temp.add(root.val);
        visit(root, sum - root.val);
        return list;
    }
    
    ArrayList<ArrayList<Integer>> list;
    ArrayList<Integer> temp;
    public void visit(TreeNode node, int sum) {
    	if (node.left == null && node.right == null) {
    		if (sum == 0){
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.addAll(temp);
                list.add(newList);
            }
    	}
    	if (node.left != null) {
    		temp.add(node.left.val);
    		visit(node.left, sum - node.left.val);
    		temp.remove(temp.size() - 1);
    	}
    	if (node.right != null) {
    		temp.add(node.right.val);
    		visit(node.right, sum - node.right.val);
    		temp.remove(temp.size() - 1);
    	}
    }

}