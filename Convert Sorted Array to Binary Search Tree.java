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
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        if (len == 0)
            return null;
        TreeNode root = new TreeNode(num[(len-1) / 2]);
        connect(num, 0, len - 1, root);
        return root;
    }

    public void connect(int[] num, int x, int y, TreeNode node) {
        if (x > y)
        	return;

        int mid = (x + y) / 2;
        if (mid - 1 >= x){
	        node.left = new TreeNode(num[(x + mid - 1) / 2]);
	        connect(num, x, mid - 1, node.left);
		}
	    if (y >= (mid + 1)){
	    	node.right = new TreeNode(num[(y + mid + 1) / 2]);
	        connect(num, mid + 1, y, node.right);
	    }
    }
}