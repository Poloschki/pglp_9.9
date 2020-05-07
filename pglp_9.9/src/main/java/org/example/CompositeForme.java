package org.example;

import java.util.ArrayList;

public class CompositeForme implements Composite {
  String nom;
  ArrayList<Composite> groupe;

  public CompositeForme(String name) {
    this.nom = name;
    groupe = new ArrayList<>();
  }

  @Override
  public void print() {
    System.out.println("Groupe : " + nom + "{");
    for (Composite forme : groupe) {
      forme.print();
    }
    System.out.println("}");
  }

  @Override
  public void move(double x, double y) {
    for (Composite forme : groupe) {
      forme.move(x, y);
    }
  }

  @Override
  public String returnName() {
    return nom;
  }

  public void add(Composite forme) {
    this.groupe.add(forme);
  }

  public void remove(String nom) {
    groupe.removeIf(forme -> nom.equals(forme.returnName()));
  }

  public void remove(Composite forme) {
    groupe.removeIf(forme1 -> forme1.equals(forme));
  }
}
