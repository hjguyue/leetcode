/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode node = head;
        ListNode save = node;
        int buffer = head.val;
        while (node != null){
        	if (node.val == buffer) {
        		node = node.next;
        		continue;
        	}
        	buffer = node.val;
        	save.next = node;
        	save = node;
        	node = node.next;
        }
        save.next = null;
        return head;
    }
}