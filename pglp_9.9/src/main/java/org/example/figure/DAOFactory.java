package org.example.figure;


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

  public static DAO<CompositeForme> getCompositeFormeDAO() {
    return new CompositeFormeDAO();
  }
}
