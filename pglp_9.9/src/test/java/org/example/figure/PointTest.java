package org.example.figure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

  @Test
  public void transpose() {

    Point p = new Point(0, 0);
    assertEquals(p.x, 0.0, 0);
    assertEquals(p.y, 0.0, 0);

    p.transpose(1, 1);
    assertEquals(p.x, 1.0, 0);
    assertEquals(p.y, 1.0, 0);

    p.transpose(-101, -101);
    assertEquals(p.x, -100.0, 0);
    assertEquals(p.y, -100.0, 0);

  }
}