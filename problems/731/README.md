# [my-calendar-ii](https://leetcode.com/problems/my-calendar-ii)

## 题解
跟[my-calendar-i](https://leetcode.com/problems/my-calendar-i)一样的操作

区别是需要找出所有与start end相交的线段

然后每次重新构建红黑树 tree map判断这些线段是否相交

时间复杂度O(n\*n\*logn)
