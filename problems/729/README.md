# [my-calendar-i](https://leetcode.com/problems/my-calendar-i)
## 题解
区间覆盖最容易想到的就是线段树和树状数组
但是这题只需要判断是否有交集
用tree map的lower bound处理
找到左边最近的区间和右边最近的区间判断是否有交集即可