package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarreTest {

  @Test
  public void move() {
    Carre c = new Carre("cer", 2, 2, 2);
    c.move(2, 2);
    assertEquals(c.p1.x, 4.0, 0);
  }

  @Test
  public void returnName() {
  }
}