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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode p = head;
        ListNode q = head.next;
        ListNode newHead = head.next;

        while (true){
            p.next = q.next;
        	q.next = p;
        	if (p.next == null || p.next.next == null) {
        		break;
        	}
        	ListNode temp = p;
        	q = p.next.next;
            p = p.next;
            temp.next = q;
        }

        return newHead;
    }
}