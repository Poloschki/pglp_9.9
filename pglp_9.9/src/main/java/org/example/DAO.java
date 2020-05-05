package org.example;

import java.sql.Connection;

public abstract class DAO<T> {
  protected Connection connection;

  public abstract T create(T obj);

  public abstract T find(String id);

  public abstract T update(T obj);

  public abstract void delete(T obj);


}
