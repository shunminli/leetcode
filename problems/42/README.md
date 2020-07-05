# [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) [接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

## Solution
* Maintain a monotonically decreasing stack
* Accumulate answer when add a higher item into stack
  * Pop all items which no higher than inserted element
  * Calculates the distance from the pop-up element to the inserted element times the height difference from the previous pop-up element
  * If Stack is not empty stats the area between top item to inserted element