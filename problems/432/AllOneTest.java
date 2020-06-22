/**
 * @(#)AllOneTest.java, Jun 22, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Lillard
 */
public class AllOneTest {

  @Test
  public void test1() {
    AllOne allOne = new AllOne();
    allOne.inc("hello");
    allOne.inc("hello");
    assertEquals(allOne.getMaxKey(), "hello");
    assertEquals(allOne.getMinKey(), "hello");
    allOne.inc("leet");
    assertEquals(allOne.getMaxKey(), "hello");
    assertEquals(allOne.getMinKey(), "leet");
  }
}
