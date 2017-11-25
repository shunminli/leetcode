# [contest-59](https://leetcode.com/contest/weekly-contest-59)
## A题解
暴力

## B题解
区间覆盖最容易想到的就是线段树和树状数组
但是这题只需要判断是否有交集
用tree map的lower bound处理
找到左边最近的区间和右边最近的区间判断是否有交集即可
## C题解
f[i][j]表示[i, j]区间所有的可能个数 从最近的以a, b, c, d结尾的子区间中转移