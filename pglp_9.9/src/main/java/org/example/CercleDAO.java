package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleDAO extends DAO<Cercle> {
  @Override
  public Cercle create(Cercle obj) {
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "INSERT INTO CERCLE (nom,x,y ,rayon) VALUES(?,?,?,?)");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.centre.x);
      preparedStatement.setDouble(3, obj.centre.y);
      preparedStatement.setDouble(4, obj.rayon);

      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    return obj;
  }

  @Override
  public Cercle find(String id) {
    Cercle cercle = null;
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "SELECT * FROM CERCLE WHERE nom = ?");
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        cercle = new Cercle(
            resultSet.getString("nom"),
            resultSet.getDouble("x"),
            resultSet.getDouble("y"),
            resultSet.getDouble("rayon"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cercle;
  }

  @Override
  public Cercle update(Cercle obj) {
    Cercle cercle = null;
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "UPDATE CERCLE set nom = ? and set x = ? and set y = ? and set rayon = ? WHERE nom = ?");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.centre.x);
      preparedStatement.setDouble(3, obj.centre.y);
      preparedStatement.setDouble(4, obj.rayon);
      preparedStatement.setString(5, obj.nom);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        cercle = new Cercle(
            resultSet.getString("nom"),
            resultSet.getDouble("x"),
            resultSet.getDouble("y"),
            resultSet.getDouble("rayon")
        );

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cercle;
  }

  @Override
  public void delete(Cercle obj) {
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "DELETE FROM CERCLE where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
