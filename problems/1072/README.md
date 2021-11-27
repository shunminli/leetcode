# [Flip Columns For Maximum Number of Equal Rows](https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/) [按列翻转得到最大值等行数](https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/)

## Solution
* it's to find the max count of same binary string
  * constructing binary string, 0: same to the firstNum, 1: others
  * store all string in a trie-tree, counting the end-point of string in trie-tree
  * search the max count of the trie-tree
