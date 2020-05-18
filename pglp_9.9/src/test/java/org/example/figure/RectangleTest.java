package org.example.figure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

  @Test
  public void move() {
    Rectangle rect = new Rectangle("TestNom", 3243.5342, 32321, 432, 433.344);
    rect.move(3323, 3232.534);
    assertEquals(3755, rect.BD.x, 0);
    assertEquals(3665.878, rect.BD.y, 0);
    assertEquals(6566.5342, rect.HG.x, 0);
    assertEquals(35553.534, rect.HG.y, 0);

  }

  @Test
  public void returnName() {
    Rectangle rect = new Rectangle("GR-_3", 43, 43, 43, 43);
    assertEquals("GR-_3", rect.returnName());
  }
}