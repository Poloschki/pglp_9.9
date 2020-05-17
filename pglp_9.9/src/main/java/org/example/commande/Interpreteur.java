package org.example.commande;

import org.example.figure.Composite;

import java.util.ArrayList;

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

  public Composite getComposite(String name) {
    for (Composite composite : compositeArrayList) {
      if (composite.returnName().equals(name)) return composite;
    }

    return null;
  }


  @Override
  public String toString() {
    return "Interpreteur{" +
        "compositeArrayList=" + compositeArrayList +
        '}';
  }
}
