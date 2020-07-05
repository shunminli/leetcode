/**
 * @(#)FriendCircles.java, Jul 05, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lillard
 */
public class FriendCircles {

  class Solution {
    public int findCircleNum(int[][] M) {
      if (M == null || M.length <= 0) {
        return 0;
      }

      final int n = M.length;
      int father[] = new int[n];
      for (int i = 0; i < n; i++) {
        father[i] = i;
      }

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (M[i][j] > 0) {
            int iRoot = findRoot(father, i);
            int jRoot = findRoot(father, j);
            if (iRoot != jRoot) {
              // Build new tree by link iRoot father to jRoot
              father[iRoot] = jRoot;
            }
          }
        }
      }

      Set<Integer> rootSet = new HashSet<>();
      for (int i = 0; i < n; i++) {
        rootSet.add(findRoot(father, i));
      }

      return rootSet.size();
    }

    private int findRoot(int father[], int x) {
      if (father[x] == x) {
        return x;
      }

      int root = findRoot(father, father[x]);
      // path compression
      father[x] = root;
      return root;
    }
  }
}
