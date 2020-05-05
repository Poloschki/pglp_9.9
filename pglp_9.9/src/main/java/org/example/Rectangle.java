package org.example;

public class Rectangle implements Forme {
  String nom;
  Point HG, BD;

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
    return "Rectangle(" + '\'' +
        ", HG=" + HG.toString() +
        ", BD=" + BD.toString() +
        ')';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }
}

