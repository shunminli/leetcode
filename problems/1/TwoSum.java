/**
 * @(#)TwoSum.java, Nov 09, 2017.
 * <p/>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lillard
 */
public class TwoSum {

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> num2Index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                final int targetNum = target - nums[i];
                if (num2Index.get(targetNum) != null) {
                    return new int[]{num2Index.get(targetNum), i};
                }

                num2Index.put(nums[i], i);
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res[0] + " " + res[1]);
    }
}
