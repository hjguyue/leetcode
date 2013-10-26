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
    public int sumNumbers(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}

        ArrayList<String> list = visit(root);
        int sum = 0;
        for (String str : list)
            sum += Integer.parseInt(str);
        return sum;
    }

    public ArrayList<String> visit(TreeNode node) {
        ArrayList<String> res =  new ArrayList<String>();
        if (node.left == null && node.right == null)
            res.add(node.val + "");
        if (node.left != null) {
            for (String str : visit(node.left))
                res.add(node.val + str);
        }
        if (node.right != null) {
            for (String str : visit(node.right))
                res.add(node.val + str);
        }
        return res;
    }
}