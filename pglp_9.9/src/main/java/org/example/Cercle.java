package org.example;

public class Cercle implements Forme {
  String nom;
  Point centre;
  double rayon;

  public Cercle(String nom, double x, double y, double rayon) {
    this.nom = nom;
    this.centre = new Point(x, y);
    this.rayon = rayon;
  }

  @Override
  public void move(double x, double y) {
    this.centre.transpose(x, y);
  }

  @Override
  public String toString() {
    return "Cercle{" +
        "centre=" + centre.toString() +
        ", rayon=" + rayon +
        '}';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }
}
