# [Range Frequency Queries](https://leetcode.com/problems/range-frequency-queries/) [区间内查询数字的频率](https://leetcode-cn.com/problems/range-frequency-queries/)

## Solution
* f\[i]\[j] means the maximum length of a sequence ending in i with a difference of j
* Traverse i ---> j and maintain the maximum value of f\[j]\[nums\[i]-nums\[j]]