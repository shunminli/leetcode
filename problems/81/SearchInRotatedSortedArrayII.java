/**
 * @(#)SearchInRotatedSortedArrayII.java, Jul 06, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

/**
 * @author Lillard
 */
public class SearchInRotatedSortedArrayII {

  class Solution {
    public boolean search(int[] nums, int target) {
      if (nums == null || nums.length <= 0) {
        return false;
      }

      return search(nums, target, 0, nums.length - 1) >= 0;
    }

    private int search(int[] nums, int target, int left, int right) {
      while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[left] == target) {
          return left;
        }

        if (nums[left] < nums[mid]) {
          if (target > nums[mid] || target < nums[left]) {
            left = mid + 1;
          } else {
            right = mid;
          }
        } else if (nums[left] > nums[mid]) {
          if (target > nums[mid] && target <= nums[right]) {
            left = mid + 1;
          } else {
            right = mid;
          }
        } else {
          left++;
        }
      }

      return -1;
    }
  }
}
