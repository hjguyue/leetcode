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
            return null;

        ListNode node = head;
        ListNode save = null;
        ListNode ans = null;
        int count = 1;
        int buffer = head.val;
        while (node.next != null) {
            if (node.next.val == buffer) {
                count = 2;
                node = node.next;
                continue;
            }
            if (count == 1) {
                if (save == null) {
                    save = node;
                    ans  = save;
                } else{
                    save.next = node;
                    save = save.next;
                }
            }
            buffer = node.next.val;
            count  = 1;
            node = node.next;
            continue;
        }
        if (count == 1) {
            if (save == null) {
                save = node;
                ans = save;
            } else {
            	save.next = node;
            }
        } else if (save != null) {
            save.next = null;
        }
        return ans;
    }
}