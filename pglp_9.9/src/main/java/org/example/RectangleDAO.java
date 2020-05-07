package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDAO extends DAO<Rectangle> {

  @Override
  public Rectangle create(Rectangle obj) {
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "INSERT INTO RECTANGLE (nom,xHG,yHG,xBD,yBD) VALUES(?,?,?,?,?)");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.HG.x);
      preparedStatement.setDouble(3, obj.HG.y);
      preparedStatement.setDouble(4, obj.BD.x);
      preparedStatement.setDouble(5, obj.BD.y);


      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    return obj;

  }

  @Override
  public Rectangle find(String id) {
    Rectangle rectangle = null;
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "SELECT * FROM RECTANGLE WHERE nom = ?");
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        rectangle = new Rectangle(
            resultSet.getString("nom"),
            resultSet.getDouble("xHG"),
            resultSet.getDouble("yHG"),
            resultSet.getDouble("xBD"),
            resultSet.getDouble("yBD"));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rectangle;

  }

  @Override
  public Rectangle update(Rectangle obj) {
    Rectangle rectangle = null;
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "UPDATE RECTANGLE set nom = ? and set xHG = ? and set yHG = ? and set xBD = ? and set yBD = ? and WHERE nom = ?");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.HG.x);
      preparedStatement.setDouble(3, obj.HG.y);
      preparedStatement.setDouble(4, obj.BD.x);
      preparedStatement.setDouble(5, obj.BD.y);

      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        rectangle = new Rectangle(
            resultSet.getString("nom"),
            resultSet.getDouble("xHG"),
            resultSet.getDouble("yHG"),
            resultSet.getDouble("xBD"),
            resultSet.getDouble("yBD"));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rectangle;
  }

  @Override
  public void delete(Rectangle obj) {
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "DELETE FROM RECTANGLE where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
