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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode n1 = newHead;
        ListNode n2 = newHead;

        while (count < n){
        	if (count < m-1)
        		n1 = n1.next;
        	
        	if (count < m)
        		n2 = n2.next;
        	
        	if (n2.next == null)
				break;

        	if (count >= m) {
        		ListNode tempNode = n1.next;
        		n1.next = n2.next;
        		n2.next = n2.next.next;
        		n1.next.next = tempNode;
        	}
            count++;
        }
        return newHead.next;
    }
}