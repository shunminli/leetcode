/**
 * @(#)SearchInRotatedSortedArrayIITest.java, Jul 06, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lillard
 */
public class SearchInRotatedSortedArrayIITest {

  @Test
  public void test1() {
    SearchInRotatedSortedArrayII.Solution solution = (new SearchInRotatedSortedArrayII()).new Solution();
    Assert.assertTrue(solution.search(new int[]{2,5,6,0,0,1,2}, 0));
  }
}
