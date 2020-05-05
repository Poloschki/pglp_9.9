package org.example;

public class Carre implements Forme {
  String nom;
  Point p1;
  double longueur;

  public Carre(String nom, double x1, double y2, double longueur) {
    this.nom = nom;
    this.p1 = new Point(x1, y2);
    this.longueur = longueur;

  }

  @Override
  public void move(double x, double y) {
    this.p1.transpose(x, y);
  }

  @Override
  public String returnName() {
    return this.nom;
  }

  @Override
  public String toString() {
    return "Carre(" + '\'' +
        ", p1=" + p1.toString() +
        ", longueur=" + longueur +
        ')';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }


}
