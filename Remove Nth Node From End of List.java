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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode save = head;
        ListNode cursor = head;
        int count = 0;
        int total = 1;
        while (cursor.next != null){
            total ++;
        	if (count < n) {
        		count ++;
        		cursor = cursor.next;
        		continue;
        	}
        	cursor = cursor.next;
        	save = save.next;
        }
        if (total == n)
        	return save.next;       
        save.next = save.next.next;
        return head;
    }
}