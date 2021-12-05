/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        ListNode head = new ListNode();
        ListNode pre = head;
        ListNode top = null;
        while ((top = q.poll()) != null) {
            pre.next = top;
            if (top.next != null) {
                q.add(top.next);
            }
            pre = pre.next;
        }
        
        return head.next;
    }
}