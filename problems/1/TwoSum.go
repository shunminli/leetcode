/**
 * Created by lillard on 11/9/17.
 */

package main

import (
	"fmt"
)

func twoSum(nums []int, target int) (res []int) {
	res = make([]int, 0)
	numMap := make(map[int]int)
	for i, v := range nums {
		targetNum := target - v
		if index, ok := numMap[targetNum]; ok {
			res = append(res, index)
			res = append(res, i)
			break
		}
		numMap[v] = i
	}

	return
}

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}
