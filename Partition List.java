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
    public ListNode partition(ListNode head, int x) {
        ListNode cursor = new ListNode(Integer.MIN_VALUE);
        ListNode save = null;
        ListNode newHead = cursor;
        cursor.next = head;

        while (true) {
            if (cursor.next == null)
                break;
            if (cursor.next.val < x)
                cursor = cursor.next;
            else {
                save = cursor;
                break;
            }
        }
        // save --> save.next .... --> cursor --> cursor.next -> cursor.next.next
        while (true) {
            if (cursor.next == null)
                break;
            if (cursor.next.val >= x) {
                cursor = cursor.next;
                continue;
            }
            ListNode temp = save.next;
            ListNode temp2 = cursor.next.next;
            save.next = cursor.next;
            cursor.next.next = temp;
            cursor.next = temp2;
            save = save.next;
        }

        return newHead.next;
    }
}