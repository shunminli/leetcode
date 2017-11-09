object TwoSum {
    
    object Solution {
        def twoSum(nums: Array[Int], target: Int): Array[Int] = {
            var numMap: Map[Int, Int] = Map()
            for (i <- 0 until nums.length) {
                val targetNum = target - nums(i)
                if (numMap.contains(targetNum)) {
                    return Array(numMap(targetNum), i)
                }

                numMap += nums(i) -> i
            }
            return null
        }
    }

    def main(args: Array[String]) = {
        val res = Solution.twoSum(Array(2, 7, 11, 15), 9)
        println(res(0), res(1))
    }
}
