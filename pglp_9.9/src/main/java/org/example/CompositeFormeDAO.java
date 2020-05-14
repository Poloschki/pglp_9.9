package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompositeFormeDAO extends DAO<CompositeForme> {
  @Override
  public CompositeForme create(CompositeForme obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "INSERT INTO GROUPE (nomGroupe,nomComposite) VALUES(?,?)");
      preparedStatement.setString(1, obj.nom);
      //ajoute le dernier éléments ajouter dans la base de donnée
      preparedStatement.setString(2, obj.groupe.get(obj.groupe.size() - 1).returnName());

      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    gestionBD.disconnect();
    return obj;
  }

  @Override
  public CompositeForme find(String id) {
    CompositeForme cf = null;
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "SELECT * FROM GROUPE WHERE nomGroupe = ?"
      );
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        cf = new CompositeForme(resultSet.getString("nomGroupe"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    gestionBD.disconnect();
    return cf;
  }

  @Override
  public CompositeForme update(CompositeForme obj) {
    return null;
  }

  @Override
  public void delete(CompositeForme obj) {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "DELETE FROM GROUPE where nomGroupe = ? OR nomComposite = ? "
      );
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setString(2, obj.nom);
      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    gestionBD.disconnect();
  }

  @Override
  public void createTable() {
    gestionBD.connect();
    try {
      PreparedStatement preparedStatement = gestionBD.conn.prepareStatement(
          "CREATE TABLE IF NOT EXISTS GROUPE(" +
              "nomGroupe varchar(100) NOT NULL," +
              "id int(10) AUTO_INCREMENT," +
              "nomComposite varchar(100) NOT NULL," +
              "PRIMARY KEY (id)); ");
      int set = preparedStatement.executeUpdate();
      assert set == 1;
      preparedStatement.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    gestionBD.disconnect();
  }
}
