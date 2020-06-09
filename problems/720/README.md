# [longest-word-in-dictionary](https://leetcode.com/problems/longest-word-in-dictionary) [词典中最长的单词](https://leetcode-cn.com/problems/longest-word-in-dictionary)

## Solution
* store all string in a trie-tree, then mark the end-point of string in trie-tree
* search the longest path (lexicographical order) which all nodes is marked
* rebuild the string by trie-tree
