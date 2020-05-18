package org.example.figure;

public class Cercle implements Forme {
  public final String nom;
  public final Point centre;
  public final double rayon;

  /**
   * Constructuer d'un cercle.
   *
   * @param nom   nom du cercle.
   * @param x     coordonées x du centre du cercle.
   * @param y     coordonnées y du centre du cercle.
   * @param rayon taille du rayon du cercle
   */
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
  public String returnName() {
    return this.nom;
  }

  @Override
  public String toString() {
    return "Cercle(" + nom
        + " ,centre="
        + centre.toString()
        + ", rayon="
        + rayon
        + ')';
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }
}
