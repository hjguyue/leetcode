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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
    		return null;
    	}
        TreeNode node = new TreeNode(preorder[0]);
           
        connnect(inorder, preorder, 0, inorder.length-1, 0, inorder.length-1, node);
        return node;
    }

    public void connnect(int[] inorder, int[] preorder, int ix, int iy, int px, int py, TreeNode node){
    	if (ix > iy || px > py)
    		return;
    	
    	int position = 0;
    	for(int i = ix; i <= iy; i++){
    		if (inorder[i] == preorder[px]) {
    			position = i;
    			break;
    		}
    	}
//    	System.out.println(ix + ", " + iy + ", " + px + ", " + py + ", " + position);
    	if (position - 1 >= ix) {
    		TreeNode leftNode = new TreeNode(preorder[px + 1]);
    		node.left = leftNode;
    		connnect(inorder, preorder, ix, position - 1, px + 1, px + position - ix, leftNode);
    	}
    	if (iy >= (position+1)) {
    		TreeNode rightNode = new TreeNode(preorder[position - ix + px + 1]);
    		node.right = rightNode;
    		connnect(inorder, preorder, position + 1, iy, px + position - ix + 1, py, rightNode);
    	}
    }
}