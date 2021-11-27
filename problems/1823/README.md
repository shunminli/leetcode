# [Find the Winner of the Circular Game](https://leetcode.com/problems/find-the-winner-of-the-circular-game/) [找出游戏的获胜者](https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/)

## Solution
* f\[i] means the winner index of i length circle
* f\[i] = (f\[i - 1] + k) % i
* f\[1] == 0
* The result is f\[n] + 1