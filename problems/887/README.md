# [Super Egg Drop](https://leetcode.com/problems/super-egg-drop/) [鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/)

## Solution
* f\[i]\[j] represents the minimum number of steps When you throw in i eggs and you still have j layers.
* We can drop an egg on the k (1 <= k <= j) layer and choose the worst case
  * If the egg is broken: f\[i - 1]\[k - 1] + 1
  * Otherwise: f\[i]\[j - k] + 1
* Note that we need to take advantage of the monotonicity of the function to maintain an x for the initial value of k
