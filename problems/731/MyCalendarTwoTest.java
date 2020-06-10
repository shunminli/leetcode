/**
 * @(#)MyCalendarTwoTest.java, Jun 10, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Lillard
 */
public class MyCalendarTwoTest {

  @Test
  public void test1() {
    MyCalendarTwo myCalendar = new MyCalendarTwo();
    assertTrue(myCalendar.book(26, 31));
    assertTrue(myCalendar.book(31, 39));
    assertTrue(myCalendar.book(24, 32));
    assertFalse(myCalendar.book(31, 36));
  }

  @Test
  public void test2() {
    MyCalendarTwo myCalendar = new MyCalendarTwo();
    assertTrue(myCalendar.book(69, 78));
    assertTrue(myCalendar.book(81, 86));
    assertTrue(myCalendar.book(80, 87));
    assertTrue(myCalendar.book(58, 66));
    assertTrue(myCalendar.book(40, 46));
    assertFalse(myCalendar.book(81, 88));
    assertTrue(myCalendar.book(40, 47));
    assertTrue(myCalendar.book(18, 25));
    assertTrue(myCalendar.book(52, 59));
    assertFalse(myCalendar.book(80, 88));
    assertFalse(myCalendar.book(58, 63));
    assertTrue(myCalendar.book(15, 21));
    assertFalse(myCalendar.book(79, 87));
    assertFalse(myCalendar.book(77, 83));
    assertTrue(myCalendar.book(9, 14));
    assertTrue(myCalendar.book(67, 76));
    assertTrue(myCalendar.book(61, 69));
    assertTrue(myCalendar.book(49, 57));
    assertTrue(myCalendar.book(2, 8));
    assertTrue(myCalendar.book(8, 15));
    assertTrue(myCalendar.book(94, 100));
    assertTrue(myCalendar.book(1, 9));
  }

  @Test
  public void test3() {
    MyCalendarTwo myCalendar = new MyCalendarTwo();
    assertTrue(myCalendar.book(55, 69));
    assertTrue(myCalendar.book(75, 86));
    assertTrue(myCalendar.book(65, 83));
    assertTrue(myCalendar.book(83, 97));
    assertTrue(myCalendar.book(86, 100));
    assertFalse(myCalendar.book(87, 99));
  }
}
