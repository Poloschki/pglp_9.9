package org.example.figure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

  @Test
  public void move() {
    Triangle tri = new Triangle("Nom", 214.32, 43, 32, 433.32, 32, 32);
    tri.move(32, 4323.32);
    assertEquals(246.32, tri.p1.x, 0);
    assertEquals(4366.32, tri.p1.y, 0);
    assertEquals(64, tri.p2.x, 0);
    assertEquals(4756.639999999999, tri.p2.y, 0);
    assertEquals(64, tri.p3.x, 0);
    assertEquals(4355.32, tri.p3.y, 0);

  }

  @Test
  public void returnName() {
    Triangle tri = new Triangle("FRK243", 3, 3, 3, 3, 3, 3);
    assertEquals("FRK243", tri.returnName());
  }
}