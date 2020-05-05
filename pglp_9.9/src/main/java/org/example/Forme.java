package org.example;

public interface Forme extends Composite {

  @Override
  void print();

  @Override
  void move(double x, double y);
}
