# [My Calendar I](https://leetcode.com/problems/my-calendar-i) [我的日程安排表 I](https://leetcode-cn.com/problems/my-calendar-i)

## Solution
* use tree-map to find the lower bound item then check item.value <= start
* use tree-map to find the higher key then check key >= end
* put key:start,value:end into tree-map
