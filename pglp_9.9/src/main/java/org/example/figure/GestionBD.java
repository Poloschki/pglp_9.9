package org.example.figure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./DB/DrawingApp";
  static final String USER = "sa";
  static final String PASS = "sa";

  Connection conn;
  Statement stmt;

  public GestionBD() {
    conn = null;
    stmt = null;
  }

  /**
   * Permet d'établir la connexion avec la base de donnée.
   */
  public void connect() {
    try {
      Class.forName(JDBC_DRIVER).newInstance();
      this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

    } catch (SQLException | ClassNotFoundException
        | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  /**
   * Permet de terminer correctement la connexion avec
   * la base de donnée.
   */
  public void disconnect() {
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (SQLException ignored) {
      ignored.printStackTrace();
    }
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (SQLException se) {
      se.printStackTrace();
    }
  }

  /**
   * Supprime tout le contenus de la base de donnée.
   */
  public void endConnection() {
    this.connect();
    try {
      PreparedStatement preparedStatement = this.conn.prepareStatement(
          "DROP Table IF EXISTS CERCLE;"
              + "DROP TABLE IF EXISTS CARRE;"
              + "DROP TABLE IF EXISTS TRIANGLE;"
              + "DROP TABLE IF EXISTS RECTANGLE;"
              + "DROP TABLE IF EXISTS GROUPE");
      int resultSet = preparedStatement.executeUpdate();
      preparedStatement.close();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
  }

  /**
   * Initialise la connection avec la base de donnée
   * en créant toutes les tables pour les formes.
   */
  public void initConnection() {
    this.connect();
    DAOFactory.getCercleDAO().createTable();
    DAOFactory.getCarreDAO().createTable();
    DAOFactory.getCompositeFormeDAO().createTable();
    DAOFactory.getRectangleDAO().createTable();
    DAOFactory.getTriangleDAO().createTable();
    this.disconnect();
  }

}

