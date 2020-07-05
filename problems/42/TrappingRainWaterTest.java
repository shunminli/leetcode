/**
 * @(#)TrappingRainWaterTest.java, Jul 05, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lillard
 */
public class TrappingRainWaterTest {

  TrappingRainWater trappingRainWater = new TrappingRainWater();

  @Test
  public void test1() {
    TrappingRainWater.Solution solution = trappingRainWater.new Solution();
    Assert.assertEquals(2, solution.trap(new int[]{2, 0, 2}));
    Assert.assertEquals(6, solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
  }
}
