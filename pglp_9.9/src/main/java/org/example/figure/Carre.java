package org.example.figure;

public class Carre implements Forme {
  public final String nom;
  public final Point p1;
  public final double longueur;

  /**
   * Constructeur du carré.
   *
   * @param nom      Nom du carré.
   * @param x        coordonnées x du point.
   * @param y        coordonnées y du point.
   * @param longueur largeur du carré.
   */
  public Carre(String nom, double x, double y, double longueur) {
    this.nom = nom;
    this.p1 = new Point(x, y);
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
    return "Carre("
        + "Nom : "
        + nom
        + ", p1="
        + p1.toString()
        + ", longueur="
        + longueur
        + ')';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }


}
