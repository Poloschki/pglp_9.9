package org.example.figure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CercleDAO extends DAO<Cercle> {
  @Override
  public void create(Cercle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
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
    gestionBD.disconnect();
  }

  @Override
  public Cercle find(String id) {
    Cercle cercle = null;
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
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
    gestionBD.disconnect();
    return cercle;
  }

  @Override
  public void update(Cercle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "UPDATE CERCLE  SET x = ? , y = ? , rayon = ? WHERE nom = ?");
      preparedStatement.setDouble(1, obj.centre.x);
      preparedStatement.setDouble(2, obj.centre.y);
      preparedStatement.setDouble(3, obj.rayon);
      preparedStatement.setString(4, obj.nom);
      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public void delete(Cercle obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM CERCLE where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      preparedStatement.close();
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
          "CREATE TABLE IF NOT EXISTS CERCLE( "
              + "nom varchar(100) NOT NULL,"
              + "x int(4) NOT NULL,"
              + "y int(4) NOT NULL,"
              + "rayon int(4) NOT NULL,"
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
    ArrayList<Composite> listCercle = new ArrayList<>();
    Cercle cercle;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM CERCLE");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        cercle = new Cercle(
            resultSet.getString("nom"),
            resultSet.getDouble("x"),
            resultSet.getDouble("y"),
            resultSet.getDouble("rayon"));
        listCercle.add(cercle);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listCercle;
  }

}
