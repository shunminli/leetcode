# [Count Different Palindromic Subsequences](https://leetcode.com/problems/count-different-palindromic-subsequences) [统计不同回文子序列](https://leetcode-cn.com/problems/count-different-palindromic-subsequences)

## Solution
* The f\[i]\[j] represents all the possible numbers in the \[i, j]
* The pre\[i]\[c] represents the position of the first letter c before index i, next\[i]\[c] is similar
* For each f\[i]\[j] we can find all f\[next\[i]\[c] + 1]\[pre\[j]\[c] - 1] (c in \['a', 'b', 'c', 'd']) to to count the total numbe
* If next\[i]\[c] == pre\[j]\[c] then there's only one possibility(single c)
* If next\[i]\[c] < pre\[j]\[c] then there have f\[next\[i]\[c] + 1]\[pre\[j]\[c] - 1] + 2 possiblilities
 * Add pair of c ====> cxxx......xxxc
 * Pair of c ====> cc
 * Single c ====> c
 * Why there is no xxx......xxx? Because it can be transferred by other states, it can avoid double counting
* For example: abaaaba，f(x) represents all palindromic subsequences in x
 * f(abaaaba) ====> a + f(baaab) + a, aa, a, b + f（aaa) + b, bb, b ====> abaaaba, abaab, ababa, abba, aba, aa, a, baaab, baab, bab, bb, b
 * When letter c == 'b' we will count f(baaab) = \[b + f(aaa) + b, bb, b], so it can not count by f(abaaaba) again
 * f(baaab) ====> b + f(aaa) + b, bb, b ====> baaab, baab, bab, bb, b
 * f(aaa) ===> a + f(a) + a, aa, a ===> aaa + aa + a
 * f(a) ===> a
