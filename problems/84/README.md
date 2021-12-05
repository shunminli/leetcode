# [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) [柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

## Solution
* Maintain a monotonic increasing stack
  * The element on the stack means what's the farthest I can go at height h
  * When a new h add to the stack, we need pop all the element which is no less than h and get the farthest index
  * The result is the max area of the stack
    * When pop element: area is the distance from element index to current multiply by element height
    * When we have iterated through all the elements: pop all element of stack and calculate area