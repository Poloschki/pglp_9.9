package org.example.commande;

import java.util.ArrayList;

import org.example.figure.Composite;



public class Interpreteur {
  ArrayList<Composite> compositeArrayList;

  public Interpreteur() {
    compositeArrayList = new ArrayList<>();
  }

  public void add(Composite composite) {
    this.compositeArrayList.add(composite);
  }

  public void addAll(ArrayList<Composite> composites) {
    this.compositeArrayList.addAll(composites);
  }

  public void removeAll() {
    this.compositeArrayList.clear();
  }

  public void remove(Composite composite) {
    compositeArrayList.removeIf(composite::equals);
  }

  /**
   * Permet de retourner le composite associe au nom.
   * Chaque composite à un nom unique.
   *
   * @param name le nom du composite que l'on checher.
   * @return le composite lui étant associé.
   */
  public Composite getComposite(String name) {
    for (Composite composite : compositeArrayList) {
      if (composite.returnName().equals(name)) {
        return composite;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "Interpreteur{"
        + "compositeArrayList="
        + compositeArrayList
        + '}';
  }
}
