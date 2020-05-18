package org.example.figure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RectangleDAO extends DAO<Rectangle> {

  @Override
  public void create(Rectangle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
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
    gestionBD.disconnect();

  }

  @Override
  public Rectangle find(String id) {
    gestionBD.connect();
    Rectangle rectangle = null;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
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
    gestionBD.disconnect();
    return rectangle;

  }

  @Override
  public void update(Rectangle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "UPDATE RECTANGLE set xHG = ? ,  yHG = ? ,xBD = ? , yBD = ?  WHERE nom = ?");
      preparedStatement.setDouble(1, obj.HG.x);
      preparedStatement.setDouble(2, obj.HG.y);
      preparedStatement.setDouble(3, obj.BD.x);
      preparedStatement.setDouble(4, obj.BD.y);
      preparedStatement.setString(5, obj.nom);

      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public void delete(Rectangle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM RECTANGLE where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public void createTable() {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "CREATE TABLE IF NOT EXISTS RECTANGLE( "
              + "nom varchar(100) NOT NULL,"
              + "xHG int(4) NOT NULL,"
              + "yHG int(4) NOT NULL,"
              + "xBD int(4) NOT NULL,"
              + "yBD int(4) NOT NULL,"
              + "PRIMARY KEY (nom));");
      int set = preparedStatement.executeUpdate();
      assert set == 1;
      preparedStatement.close();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public ArrayList<Composite> findAll() {
    gestionBD.connect();
    ArrayList<Composite> listRect = new ArrayList<>();
    Rectangle rect;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM RECTANGLE");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        rect = new Rectangle(
            resultSet.getString("nom"),
            resultSet.getDouble("xHG"),
            resultSet.getDouble("yHG"),
            resultSet.getDouble("xBD"),
            resultSet.getDouble("yBD"));
        listRect.add(rect);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listRect;
  }
}

