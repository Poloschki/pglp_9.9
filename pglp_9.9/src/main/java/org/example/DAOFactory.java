package org.example;

public class DAOFactory {

  public static DAO<Carre> getCarreDAO() {
    return new CarreDAO();
  }

  public static DAO<Cercle> getCercleDAO() {
    return new CercleDAO();
  }

  public static DAO<Rectangle> getRectangleDAO() {
    return new RectangleDAO();
  }

  public static DAO<Triangle> getTriangleDAO() {
    return new TriangleDAO();
  }
}
