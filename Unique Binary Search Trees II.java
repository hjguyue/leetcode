/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        int num[] = new int[n];
    	for (int i = 0; i < n; i++) {
    		num[i] = i+1;
    	}
    	return func(0, n-1, num);
    }

    public ArrayList<TreeNode> func(int start, int end, int[] num){
    	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    	if (start == end){
    		list.add(new TreeNode(num[start]));
    		return list;
    	}
    	if (start > end){
    		list.add(null);
    		return list;
    	}
    	
    	for (int i = start; i <= end; i++) {
    		ArrayList<TreeNode> left = func(start, i - 1, num);
    		ArrayList<TreeNode> right = func(i + 1, end, num);
    		for (TreeNode l:left) {
    			for (TreeNode r:right) {
    				TreeNode node = new TreeNode(num[i]);
    				node.left = l;
    				node.right= r;
    				list.add(node);
    			}
    		}
    	}
    	return list;
    }
}