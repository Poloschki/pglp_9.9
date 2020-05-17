package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CercleTest {

  @Test
  public void move() {
    Cercle c = new Cercle("cer", 3, 3, 3);
    assertEquals(3.0, c.centre.x, 0);
    assertEquals(3.0, c.centre.y, 0);

    c.move(999, 999);
    assertEquals(1002.0, c.centre.x, 0);
    assertEquals(1002.0, c.centre.y, 0);

    c.move(-2000, -2000);
    assertEquals(-998, c.centre.x, 0);
    assertEquals(-998.0, c.centre.y, 0);
  }
}