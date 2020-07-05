/**
 * @(#)MaxAreaofIsland.java, Jul 05, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lillard
 */
public class MaxAreaofIsland {

  class Solution {

    public int[][]direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private class Node {
      int x;
      int y;

      Node(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }
    public int maxAreaOfIsland(int[][] grid) {
      if (grid == null) {
        return 0;
      }

      int ans = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] > 0) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(i, j));
            int areaSize = 0;
            while (!queue.isEmpty()) {
              Node node = queue.poll();
              if (node.x < 0 || node.x >= grid.length) {
                continue;
              }
              if (node.y < 0 || node.y >= grid[node.x].length) {
                continue;
              }
              if (grid[node.x][node.y] <= 0) {
                continue;
              }

              // find 1
              grid[node.x][node.y] = 0;
              areaSize++;

              for (int d = 0; d < 4; d++) {
                int x = node.x + direction[d][0];
                int y = node.y + direction[d][1];
                queue.add(new Node(x, y));
              }
            }
            if (areaSize > ans) {
              ans = areaSize;
            }
          }
        }
      }

      return ans;
    }
  }
}
