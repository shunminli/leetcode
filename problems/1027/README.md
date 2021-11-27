# [Longest Arithmetic Subsequence](https://leetcode.com/problems/longest-arithmetic-subsequence/) [最长等差数列](https://leetcode-cn.com/problems/longest-arithmetic-subsequence/)

## Solution
* f\[i]\[j] means the maximum length of a sequence ending in i with a difference of j
* Traverse i ---> j and maintain the maximum value of f\[j]\[nums\[i]-nums\[j]]
