# [Flip Binary Tree To Match Preorder Traversal](https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/) [翻转二叉树以匹配先序遍历](https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/)

## Solution
* Dfs the binary tree and check the pre-order
  * If left-node's val is not equal to the voyage, must flip the root
  * If root's val is not equal to the voyage, It's invalid