# [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) [合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

## Solution
* Use PriorityQueue to add all ListNode head
* Override Comparator by ListNode.val
* Find the min element of PriorityQueue and add it's next to PriorityQueue
* Repeat the previous step until queue is empty