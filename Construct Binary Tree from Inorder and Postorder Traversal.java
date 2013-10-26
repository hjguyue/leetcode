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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (inorder.length == 0) {
    		return null;
    	}
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
           
        connnect(inorder, postorder, 0, inorder.length-1, 0, inorder.length-1, node);
        return node;
    }

    public void connnect(int[] inorder, int[] postorder, int ix, int iy, int px, int py, TreeNode node){
    	if (ix > iy || px > py)
    		return;
    	
    	int position = 0;
    	for(int i = ix; i <= iy; i++){
    		if (inorder[i] == postorder[py]) {
    			position = i;
    			break;
    		}
    	}
//    	System.out.println(ix + ", " + iy + ", " + px + ", " + py + ", " + position);
    	if (position - 1 >= ix) {
    		TreeNode leftNode = new TreeNode(postorder[px + position - ix - 1]);
    		node.left = leftNode;
    		connnect(inorder, postorder, ix, position - 1, px, px + position - ix - 1, leftNode);
    	}
    	if (iy >= (position+1)) {
    		TreeNode rightNode = new TreeNode(postorder[py - 1]);
    		node.right = rightNode;
    		connnect(inorder, postorder, position + 1, iy, px + position - ix, py -1, rightNode);
    	}
    }
}