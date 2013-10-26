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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return visit(p, q);
    }

    public boolean visit(TreeNode t1, TreeNode t2){
    	if (t1 == null || t2 == null) {
    		if (t1 == null && t2 == null)
    			return true;
    		return false;
    	}
    	if (t1.val != t2.val)
    		return false;
    	if (visit(t1.left, t2.left) && visit(t1.right, t2.right)
    		return true;

    	return false;
    }

}