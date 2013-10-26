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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cursor_1 = l1;
		ListNode cursor_2 = l2;

		String result = "";
		int save = 0;
		int x = 0;
		int y = 0;
		while(cursor_1 != null || cursor_2 != null){
			x = 0;
			y = 0;
			if (cursor_1 != null){
				x = cursor_1.val;
				cursor_1 = cursor_1.next;
			}
			if (cursor_2 != null){
				y = cursor_2.val;
				cursor_2 = cursor_2.next;	
			}

			int val  = save + x + y;
			save = val / 10;
			result = result + (val % 10);
		}
		if (save == 1) {
			result = result + 1;
		}

		int len = result.length();
		ListNode head = new ListNode(Integer.parseInt(result.substring(0,1)));
		ListNode cursor = head;
		for(int i = 1; i < result.length(); i++){
			ListNode node = new ListNode(Integer.parseInt(result.substring(i, i+1)));
			cursor.next = node;
			cursor = node;
		}
		return head;
	}
}