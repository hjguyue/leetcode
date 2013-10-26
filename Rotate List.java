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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return head;
        int count = 0;
        ListNode cursor = head;
        ListNode temp = null;
        ListNode save = head;
        // get length:
        int length = 0;
        while (cursor != null){
            length++;
        	cursor = cursor.next;
        }
        cursor = head;
        n = n % length;
        while (cursor != null){
            temp = cursor;
            cursor = cursor.next;
        	if (count > n)
        		save = save.next;
        	count ++;
        }
        if (count == n)
			return head;
        temp.next = head;
        head = save.next;
        save.next = null;
        return head;
    }
}