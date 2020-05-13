package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarreDAOTest {

  @Test
  public void create() {
    Carre c = new Carre("c", 10, 10, 10);
    CarreDAO dao = new CarreDAO();
    assertEquals(dao.create(c), c);
  }

  @Test
  public void find() {
  }

  @Test
  public void update() {
  }

  @Test
  public void delete() {
    CarreDAO dao = new CarreDAO();
    dao.delete(new Carre("c", 10, 10, 10));
  }
}