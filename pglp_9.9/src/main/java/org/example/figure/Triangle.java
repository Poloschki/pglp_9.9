package org.example.figure;

public class Triangle implements Forme {
  String nom;
  Point p1;
  Point p2;
  Point p3;

  /**
   * Constructeur du triangle, qui contient 3 points.
   *
   * @param nom nom du triangle.
   * @param x1  coordonnées x du premier point.
   * @param y1  coordonnées y du premier point.
   * @param x2  coordonnées x du deuxième point.
   * @param y2  coordonnées y du deuxième point.
   * @param x3  coordonnées x du troisième point.
   * @param y3  coordonnées y du troisième point.
   */
  public Triangle(String nom, double x1, double y1, double x2, double y2, double x3, double y3) {
    this.nom = nom;
    this.p1 = new Point(x1, y1);
    this.p2 = new Point(x2, y2);
    this.p3 = new Point(x3, y3);
  }

  @Override
  public void move(double x, double y) {
    this.p1.transpose(x, y);
    this.p2.transpose(x, y);
    this.p3.transpose(x, y);

  }

  @Override
  public String returnName() {
    return this.nom;
  }

  @Override
  public String toString() {
    return "Triangle("
        + nom
        + ", p1="
        + p1.toString()
        + ", p2="
        + p2.toString()
        + ", p3="
        + p3.toString()
        + ')';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }
}
