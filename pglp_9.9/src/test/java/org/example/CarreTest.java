package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CarreTest {

  @Test
  public void move() {
    Carre c = new Carre("cer", 2, 2, 2);
    c.move(2, 2);
    assertEquals(c.p1.x, 4.0, 0);
  }

  @Test
  public void returnName() {
    Carre c = new Carre("_4m:", 0, 0, 0);
    assertSame("_4m:", c.returnName());
  }
}