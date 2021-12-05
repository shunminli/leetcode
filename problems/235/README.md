# [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) [二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

## Solution
* Search the binary search tree similar to binary search
  * If both are less than root.val then search left sub-tree
  * If both are more than root.val then search right sub-tree
  * Otherwise root is the result