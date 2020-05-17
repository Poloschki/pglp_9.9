package org.example.figure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TriangleDAO extends DAO<Triangle> {
  @Override
  public void create(Triangle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "INSERT INTO TRIANGLE (nom,x1,y1,x2,y2,x3,y3) VALUES(?,?,?,?,?,?,?)");
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
    gestionBD.disconnect();
  }

  @Override
  public Triangle find(String id) {
    gestionBD.connect();
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
    gestionBD.disconnect();
    return triangle;
  }

  @Override
  public void update(Triangle obj) {
    gestionBD.connect();
    Triangle triangle = null;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "UPDATE TRIANGLE set x1 = ? , y1 = ? , x2 = ? , y2 = ? , x3 = ? , y3 = ?  WHERE nom = ?");
      preparedStatement.setDouble(1, obj.p1.x);
      preparedStatement.setDouble(2, obj.p1.y);
      preparedStatement.setDouble(3, obj.p2.x);
      preparedStatement.setDouble(4, obj.p2.y);
      preparedStatement.setDouble(5, obj.p3.x);
      preparedStatement.setDouble(6, obj.p3.y);
      preparedStatement.setString(7, obj.nom);
      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    gestionBD.connect();
  }

  @Override
  public void delete(Triangle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM TRIANGLE where nom = ? ");
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
          "CREATE TABLE IF NOT EXISTS TRIANGLE( "
              + "nom varchar(100) NOT NULL,"
              + "x1 int(4) NOT NULL,"
              + "y1 int(4) NOT NULL,"
              + "x2 int(4) NOT NULL,"
              + "y2 int(4) NOT NULL,"
              + "x3 int(4) NOT NULL,"
              + "y3 int(4) NOT NULL,"
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
    ArrayList<Composite> listTri = new ArrayList<>();
    Triangle tri;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM TRIANGLE");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        tri = new Triangle(
            resultSet.getString("nom"),
            resultSet.getDouble("x1"),
            resultSet.getDouble("y1"),
            resultSet.getDouble("x2"),
            resultSet.getDouble("y2"),
            resultSet.getDouble("x3"),
            resultSet.getDouble("y3"));
        listTri.add(tri);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listTri;
  }
}
