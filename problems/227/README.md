# [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/) [227. 基本计算器 II](https://leetcode-cn.com/problems/basic-calculator-ii/)

## Solution
* Dfs the string and split by operation
  * Similar to the subsequent traversal of a binary tree
  * 1st: split by '+' and '-'
  * 2nd: split by '*' and '/'
  * 3rd: calculate the value of substring