/**
 * Created by lillard on 11/9/17.
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const numMap = {};
    for (let i = 0; i < nums.length; i++) {
        const targetNum = target - nums[i];
        if (numMap[targetNum] != null && numMap[targetNum] != undefined) {
            return [numMap[targetNum], i];
        }

        numMap[nums[i]] = i;
    }

    return null
};

console.log(twoSum([2, 7, 11, 15], 9));