# [longest-word-in-dictionary](https://leetcode.com/problems/longest-word-in-dictionary)

## 题解
给定1000个字符串集合S 每个字符串长度在30以内 求一个最长的字符串 使得所有前缀都在S内

简单搞应该是可以暴力枚举字符串 然后再枚举前缀是否在集合中

好像trie树也蛮简单的 还可以做到1000 * 30的复杂度 所以我就用trie树了