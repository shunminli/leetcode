# [Count Different Palindromic Subsequences](https://leetcode.com/problems/count-different-palindromic-subsequences) [统计不同回文子序列](https://leetcode-cn.com/problems/count-different-palindromic-subsequences)

## Solution
* f\[i]\[j] represents all the possible numbers in the \[i, j]
* pre\[i]\[c] represents the position of the first letter c before index i, next\[i]\[c] is similar
* for each f\[i]\[j] we can find all f\[next\[i]\[c] + 1]\[pre\[j]\[c] - 1] (c in \['a', 'b', 'c', 'd']) to to count the total number
* if next\[i]\[c] == pre\[j]\[c] then there's only one possibility
* if next\[i]\[c] < pre\[j]\[c] then there have f\[next\[i]\[c] + 1]\[pre\[j]\[c] - 1] + 2(add pair of c or) possibilities
