/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cursor = head;
        while(cursor != null){
        	len++;
        	cursor = cursor.next;
        }
        if (len == 0)
        	return null;
        
        int num[] = new int[len];
        cursor = head;
        int count = 0;
        while(cursor != null){
        	num[count] = cursor.val;
        	cursor = cursor.next;
        	count ++;
        }

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