/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    HashMap<RandomListNode, RandomListNode> map;
    public RandomListNode copyRandomList(RandomListNode head) {
        map = new HashMap<RandomListNode, RandomListNode>();
        if (head == null) {
            return null;
        }

        RandomListNode curHead = new RandomListNode(head.label);
        RandomListNode newHead = curHead;
        map.put(head, curHead);
        map.put(null, null);
        while (head != null) {
            if (!map.containsKey(head.next)) {
                curHead.next = new RandomListNode(head.next.label);
                map.put(head.next, curHead.next);
            }
            else
            	curHead.next = map.get(head.next);

            if (!map.containsKey(head.random)) {
                curHead.random = new RandomListNode(head.random.label);
                map.put(head.random, curHead.random);
            }
            else
            	curHead.random = map.get(head.random);

            curHead = map.get(head.next);
            head = head.next;
        }
        return newHead;
    }
}