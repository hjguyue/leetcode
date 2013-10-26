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

    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(1, new Comparator<ListNode>() {
        public int compare(ListNode n1, ListNode n2) {
            if (n1.val > n2.val)
                return 1;
            return -1;
        }
    });

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        queue.clear();
        for (ListNode node : lists){
        	if (node != null)
        		queue.add(node);	
        }

        ListNode head = new ListNode(0);
        ListNode cursor = head;
        while (queue.size() != 0) {
            ListNode node = queue.poll();
            cursor.next = node;
            cursor = cursor.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return head.next;
    }
}