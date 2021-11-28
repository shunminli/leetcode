# [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

## Solution
* Dfs the binary search tree
  * Check left subtree is a binary search tree
  * Check right subtree is a binary search tree
  * Check max value of left subtree is less than root
  * Check min value of right subtree is right than root