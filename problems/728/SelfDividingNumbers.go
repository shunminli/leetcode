/**
 * Created by lillard on 11/22/17.
 */
package main

import "fmt"

func checkNumber(x int) bool {
	for tmp := x; tmp > 0; tmp /= 10 {
		mod := tmp % 10
		if mod == 0 || x % mod > 0 {
			return false
		}
	}

	return true
}

func selfDividingNumbers(left int, right int) (res []int) {
	res = make([]int, 0)

	for x := left; x <= right; x++ {
		if checkNumber(x) {
			res = append(res, x)
		}
	}

	return
}

func main() {
	fmt.Println(selfDividingNumbers(1, 22))
}