package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreDAO extends DAO<Carre> {
  @Override
  public Carre create(Carre obj) {
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "INSERT INTO CARRE (nom,x,y ,longueur) VALUES(?,?,?,?)");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.p1.x);
      preparedStatement.setDouble(3, obj.p1.y);
      preparedStatement.setDouble(4, obj.longueur);

      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    return obj;
  }

  @Override
  public Carre find(String id) {
    Carre carre = null;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM CARRE WHERE nom = ?");
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        carre = new Carre(
            resultSet.getString("nom"),
            resultSet.getDouble("x"),
            resultSet.getDouble("y"),
            resultSet.getDouble("longueur"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return carre;
  }

  @Override
  public Carre update(Carre obj) {
    Carre carre = null;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "UPDATE CARRE set nom = ? and set x = ? and set y = ? and set longueur = ? WHERE nom = ?");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.p1.x);
      preparedStatement.setDouble(3, obj.p1.y);
      preparedStatement.setDouble(4, obj.longueur);
      preparedStatement.setString(5, obj.nom);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        carre = new Carre(
            resultSet.getString("nom"),
            resultSet.getDouble("x"),
            resultSet.getDouble("y"),
            resultSet.getDouble("longueur")
        );

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return carre;
  }

  @Override
  public void delete(Carre obj) {
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM CARRE where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void createTable() {

  }
}
