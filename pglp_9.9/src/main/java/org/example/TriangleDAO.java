package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleDAO extends DAO<Triangle> {
  @Override
  public Triangle create(Triangle obj) {
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "INSERT INTO TRIANGLE (nom,x1,y1,x2,y2,x3,y3) VALUES(?,?,?,?,?,?)");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.p1.x);
      preparedStatement.setDouble(3, obj.p1.y);
      preparedStatement.setDouble(4, obj.p2.x);
      preparedStatement.setDouble(5, obj.p2.y);
      preparedStatement.setDouble(6, obj.p3.x);
      preparedStatement.setDouble(7, obj.p3.y);

      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    return obj;
  }

  @Override
  public Triangle find(String id) {
    Triangle triangle = null;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM CARRE WHERE nom = ?");
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        triangle = new Triangle(
            resultSet.getString("nom"),
            resultSet.getDouble("x1"),
            resultSet.getDouble("y1"),
            resultSet.getDouble("x2"),
            resultSet.getDouble("y2"),
            resultSet.getDouble("x3"),
            resultSet.getDouble("y3"));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return triangle;
  }

  @Override
  public Triangle update(Triangle obj) {
    Triangle triangle = null;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "UPDATE TRIANGLE set nom = ? and set x1 = ? and set y1 = ? and set x2 = ? and set y2 = ? and set x3 = ? and set y3 = ?  WHERE nom = ?");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.p1.x);
      preparedStatement.setDouble(3, obj.p1.y);
      preparedStatement.setDouble(4, obj.p2.x);
      preparedStatement.setDouble(5, obj.p2.y);
      preparedStatement.setDouble(6, obj.p3.x);
      preparedStatement.setDouble(7, obj.p3.y);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        triangle = new Triangle(
            resultSet.getString("nom"),
            resultSet.getDouble("x1"),
            resultSet.getDouble("y1"),
            resultSet.getDouble("x2"),
            resultSet.getDouble("y2"),
            resultSet.getDouble("x3"),
            resultSet.getDouble("y3")
        );

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return triangle;
  }

  @Override
  public void delete(Triangle obj) {
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM TRIANGLE where nom = ? ");
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
