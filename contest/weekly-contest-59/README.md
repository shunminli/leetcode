# [contest-59](https://leetcode.com/contest/weekly-contest-59)

## A题解
暴力

## B题解
区间覆盖最容易想到的就是线段树和树状数组

但是这题只需要判断是否有交集

用tree map的lower bound处理

找到左边最近的区间和右边最近的区间判断是否有交集即可

时间复杂度O(n*logn)

## C题解
f[i][j]表示[i, j]区间所有的可能个数 从最近的以a, b, c, d结尾的子区间中转移
时间复杂度O(n*n)

## D题解
跟B题一样的操作

区别是需要找出所有与start end相交的线段

然后每次重新构建红黑树 tree map判断这些线段是否相交

时间复杂度O(n\*n\*logn)

更优秀的解法 用树状数组做到O(nlogn)

由于是在线计算 没有办法离散化 需要用hash map