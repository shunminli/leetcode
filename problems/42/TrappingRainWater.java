/**
 * @(#)TrappingRainWater.java, Jul 05, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import java.util.Stack;

/**
 * @author Lillard
 */
public class TrappingRainWater {

  public class Solution {

    public int trap(int[] height) {
      if (height == null) {
        return 0;
      }

      Stack<Integer> indexStack = new Stack<>();
      int ans = 0;
      for (int i = 0; i < height.length; i++) {
        int h = height[i];
        if (h <= 0) {
          continue;
        }
        int markedHeight = 0;
        while (!indexStack.empty() && height[indexStack.peek()] <= h) {
          // pop all items no higher than h
          int preIndex = indexStack.pop();
          int preHeight = height[preIndex];
          int deltaHeight = preHeight - markedHeight;
          markedHeight = preHeight;
          ans += deltaHeight * (i - preIndex - 1);
        }
        if (!indexStack.empty()) {
          // stack top higher than h
          int preIndex = indexStack.peek();
          int deltaHeight = h - markedHeight;
          ans += deltaHeight * (i - preIndex - 1);
        }

        indexStack.add(i);
      }

      return ans;
    }
  }
}
