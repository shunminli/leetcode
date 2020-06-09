//    123
//    456
//-------
//     18
//    12
//    6
//
//    15
//   10
//   5
//
//   12
//   8
//  4
//-------
//  56088

var f[220] int
var arr1[110] int
var arr2[110] int

func multiply(num1 string, num2 string) string {
    var len1 int = len(num1)
    var len2 int = len(num2)
    var maxLen int = len1 + len2

    for i := 0; i < maxLen; i++ {
        f[i] = 0
    }
    for i := 0; i < len1; i++ {
        arr1[i] = int(num1[len1 - 1 - i] - '0')
    }
    for i := 0; i < len2; i++ {
        arr2[i] = int(num2[len2 - 1 - i] - '0')
    }
    for i := 0; i < len1; i++ {
        for j := 0; j < len2; j++ {
            var x int = i + j
            f[x] += arr1[i] * arr2[j]
            for ; f[x] >= 10 && x < maxLen; x++ {
                f[x + 1] += f[x] / 10;
                f[x] %= 10;
            }
        }
    }

    var n int = maxLen - 1
    for ; f[n] == 0 && n > 0; n-- {

    }

    var ans string = ""
    for ; n >= 0; n-- {
        ans += string(f[n] + '0')
    }
    return ans
}
