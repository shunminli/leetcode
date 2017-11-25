/**
 * Created by lillard on 11/25/17.
 */

package main

import "fmt"

const MOD int = 1e9 + 7
const MAXN int = 1007
var a[MAXN] int
var f[MAXN][MAXN] int
var last[4] int
var first[4] int
var next[MAXN][4] int
var pre[MAXN][4] int

func F(left int, right int) int {
	if left > right {
		return 0
	}

	if f[left][right] != -1 {
		return f[left][right]
	}

	total := 0
	for c := 0; c < 4; c++ {
		i := next[left][c]
		j := pre[right][c]
		if left <= i && j <= right {
			if i < j {
				total += F(i+1, j-1) + 2
			} else if i == j {
				total++
			}
		}
		if total >= MOD {
			total -= MOD
		}
	}

	f[left][right] = total
	return f[left][right]
}

func countPalindromicSubsequences(S string) int {
	n := len(S)
	for i := 0; i < n ; i++ {
		a[i] = int(S[i] - 'a')
		for j := 0; j < n; j++ {
			f[i][j] = -1
		}
	}
	for i := 0; i < 4; i++ {
		last[i] = MAXN
		first[i] = -1
	}

	for i := 0; i < n; i++ {
		last[a[i]] = i
		for c := 0; c < 4; c++ {
			pre[i][c] = last[c]
		}
	}

	for i := n - 1; i >= 0; i-- {
		first[a[i]] = i
		for c := 0; c < 4; c++ {
			next[i][c] = first[c]
		}
	}

	return F(0, n - 1)
}

func main() {
	fmt.Println(countPalindromicSubsequences("bccb"))
	fmt.Println(countPalindromicSubsequences("abababa"))
}