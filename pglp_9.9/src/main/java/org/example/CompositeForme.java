package org.example;

import java.util.ArrayList;

public class CompositeForme implements Composite {
  String nom;
  ArrayList<Forme> groupe;

  public CompositeForme(String name) {
    this.nom = name;
    groupe = new ArrayList<>();
  }

  @Override
  public void print() {
    for (Forme forme : groupe) {
      forme.print();
    }
  }

  @Override
  public void move(double x, double y) {
    for (Forme forme : groupe) {
      forme.move(x, y);
    }
  }

  public void add(Forme forme) {
    this.groupe.add(forme);
  }

  public void remove(String nom) {
    groupe.removeIf(forme -> nom.equals(forme.returnName()));
  }

  public void remove(Forme forme) {
    groupe.removeIf(forme1 -> forme1.equals(forme));
  }
}
