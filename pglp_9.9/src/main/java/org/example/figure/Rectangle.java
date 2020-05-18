package org.example.figure;

public class Rectangle implements Forme {
  String nom;
  Point HG;
  Point BD;

  /**
   * Constructeur du rectangle.
   *
   * @param nom nom du rectangle.
   * @param xHG coordonnées x du point en haut à gauche.
   * @param yHG coordonnées y du point en haut à gauche.
   * @param xBD coordonnées x du point en bas à droite.
   * @param yBD coordonnées y du point en bas à droite.
   */
  public Rectangle(String nom, double xHG, double yHG, double xBD, double yBD) {
    this.nom = nom;
    this.BD = new Point(xBD, yBD);
    this.HG = new Point(xHG, yHG);
  }

  @Override
  public void move(double x, double y) {
    this.HG.transpose(x, y);
    this.BD.transpose(x, y);
  }

  @Override
  public String returnName() {
    return this.nom;
  }

  @Override
  public String toString() {
    return "Rectangle("
        + nom
        + ", HG="
        + HG.toString()
        + ", BD="
        + BD.toString()
        + ')';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }
}

