/**
 * @(#)MergeKSortedLists.java, Jun 24, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Lillard
 */
public class MergeKSortedLists {

  class Solution {

    public class ListNode {

      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
        this.val = val;
      }

      ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
      }
    }

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length <= 0) {
        return null;
      }

      ListNode ans = new ListNode(0, null);
      ListNode tmp = ans;

      PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(a -> a.val));
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          queue.add(lists[i]);
        }
      }

      while (queue.size() > 0) {
        ListNode min = queue.poll();
        if (min.next != null) {
          queue.add(min.next);
        }

        tmp.next = min;
        tmp = tmp.next;
        tmp.next = null;
      }

      return ans.next;
    }
  }
}