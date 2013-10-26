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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        int count = 1;
        ListNode newHead = new ListNode(0);
        ListNode result = newHead;
        ListNode cursor = head;
        ListNode tempHead = null;
        ListNode tempTail = null;
        newHead.next = head;
        
        while (cursor != null){
        	ListNode tempNode = cursor.next;
        	if (count % k == 1) {
        		tempHead = cursor;
        	}
        	if (count % k == 0 && count > 0) {
        		tempTail = cursor;
        		Nodes nodes = reverse(tempHead, tempTail);
        		newHead.next = nodes.head;
        		newHead = nodes.tail;
        	}
        	cursor = tempNode;
        	count ++;
        }
        return result.next;
    }

    public Nodes reverse(ListNode head, ListNode tail){
    	Nodes nodes = new Nodes();
    	ListNode cursor = head;
    	nodes.head = tail;
    	nodes.tail = head;
    	if (head == tail || head == null)
			return nodes;
    	while (cursor != nodes.head){
    		ListNode tempNode = nodes.head.next;
    		nodes.head.next = cursor;
    		cursor = cursor.next;
    		nodes.head.next.next = tempNode;
    	}
    	return nodes;
    }

}

class Nodes{
	ListNode head;
	ListNode tail;
}