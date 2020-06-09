# [My Calendar II](https://leetcode.com/problems/my-calendar-ii) [我的日程安排表 II](https://leetcode-cn.com/problems/my-calendar-ii/)

## Solution
* It's similar to [My Calendar I](../problems/729)
*

区别是需要找出所有与start end相交的线段

然后每次重新构建红黑树 tree map判断这些线段是否相交

时间复杂度O(n\*n\*logn)
