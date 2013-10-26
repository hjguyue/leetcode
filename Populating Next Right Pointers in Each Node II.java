/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return ;

        ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);
        visit(list);
    }

    public void visit(ArrayList<TreeLinkNode> list) {
        if (list.size() == 0)
            return;

        list.get(0).next = null;
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        ArrayList<TreeLinkNode> nextList = new ArrayList<TreeLinkNode>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).right != null)
                nextList.add(list.get(i).right);
            if (list.get(i).left != null)
                nextList.add(list.get(i).left);
        }
        visit(nextList);
    }
}