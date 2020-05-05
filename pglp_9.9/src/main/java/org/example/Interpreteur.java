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

  public void move() {

  }

  public void create() {

  }
}
