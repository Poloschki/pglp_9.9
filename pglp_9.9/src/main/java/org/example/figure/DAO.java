package org.example.figure;

import java.util.ArrayList;

public abstract class DAO<T> {
  protected GestionBD gestionBD = new GestionBD();

  public abstract void create(T obj);

  public abstract T find(String id);

  public abstract void update(T obj);

  public abstract void delete(T obj);

  public abstract void createTable();

  public abstract ArrayList<Composite> findAll();

}
