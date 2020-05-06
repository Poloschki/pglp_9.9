package org.example;

import java.util.ArrayList;

public class Interpreteur {
  ArrayList<Composite> compositeArrayList;

  public Interpreteur() {
    compositeArrayList = new ArrayList<>();
  }

  public void add(Composite composite) {
    this.compositeArrayList.add(composite);
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

  public void updateComposite(Composite composite) {
    int i = 0;
    for (Composite compo : compositeArrayList) {
      if (compo.returnName().equals(composite.returnName())) {
        compositeArrayList.set(i, composite);
      }
      i++;
    }
  }

  @Override
  public String toString() {
    return "Interpreteur{" +
        "compositeArrayList=" + compositeArrayList +
        '}';
  }
}
