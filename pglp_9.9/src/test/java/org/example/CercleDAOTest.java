package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CercleDAOTest {


  @Test
  public void create() {
    Cercle c;
    CercleDAO dao;
    c = new Cercle("c", 10, 10, 10);
    dao = new CercleDAO();
    assertEquals(dao.create(c), c);

  }

  @Test
  public void find() {
    Cercle c, c2;
    CercleDAO dao;
    c = new Cercle("c2", 10, 10, 10);
    dao = new CercleDAO();
    dao.create(c);
    c2 = dao.find("c2");
    assertEquals(c.nom, c2.nom);

  }

  @Test
  public void update() {
    CercleDAO dao = new CercleDAO();
    Cercle c = new Cercle("c3", 1, 2, 3);
    Cercle c2;
    dao.create(c);
    c.move(2, 2);

    c2 = dao.update(c);
    assertEquals(c2.nom, c.nom);
    assertEquals(c2.rayon, c.rayon, 0);
    assertEquals(c2.centre.x, c.centre.x, 0);
  }

  @Test
  public void delete() {
    CercleDAO dao = new CercleDAO();
    dao.delete(new Cercle("c", 10, 10, 10));
    dao.delete(new Cercle("c2", 10, 10, 10));
    dao.delete(new Cercle("c3", 3, 5, 3));
  }

}