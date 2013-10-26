public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(Integer.MIN_VALUE);
        ListNode result = node;
        node.next = l1;
        
        while(true){
            if (l2 == null)
        		break;
        	if (node.next == null) {
        		node.next = l2;
        		break;
        	}
        	
        	if(node.next.val <= l2.val)
        		node = node.next;
        	else{
        		ListNode tempNode = l2.next;
        		l2.next = node.next;
        		node.next = l2;
        		l2 = tempNode;
        	}
        }
        return result.next;
    }
}