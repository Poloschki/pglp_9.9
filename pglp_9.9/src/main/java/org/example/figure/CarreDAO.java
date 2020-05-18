package org.example.figure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarreDAO extends DAO<Carre> {
  @Override
  public void create(Carre obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "INSERT INTO CARRE (nom,x,y ,longueur) VALUES(?,?,?,?)");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setDouble(2, obj.p1.x);
      preparedStatement.setDouble(3, obj.p1.y);
      preparedStatement.setDouble(4, obj.longueur);

      int result = preparedStatement.executeUpdate();
      preparedStatement.close();
      assert result == 1;
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public Carre find(String id) {
    gestionBD.connect();
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
    gestionBD.disconnect();
    return carre;
  }

  @Override
  public void update(Carre obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "UPDATE CARRE set x = ? , y = ? , longueur = ? WHERE nom = ?");
      preparedStatement.setDouble(1, obj.p1.x);
      preparedStatement.setDouble(2, obj.p1.y);
      preparedStatement.setDouble(3, obj.longueur);
      preparedStatement.setString(4, obj.nom);
      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public void delete(Carre obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM CARRE where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      assert resultSet == 1;
      preparedStatement.close();
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
          "CREATE TABLE IF NOT EXISTS CARRE( "
              + "nom varchar(100) NOT NULL,"
              + "x int(4) NOT NULL,"
              + "y int(4) NOT NULL,"
              + "longueur int(4) NOT NULL,"
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
    ArrayList<Composite> listCarre = new ArrayList<>();
    Carre carre;
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM CARRE");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        carre = new Carre(
            resultSet.getString("nom"),
            resultSet.getDouble("x"),
            resultSet.getDouble("y"),
            resultSet.getDouble("longueur"));
        listCarre.add(carre);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listCarre;
  }
}
