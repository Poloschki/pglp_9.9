package org.example;

import java.sql.*;

public class GestionBD {
  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./DB/DrawingApp";

  //  Database credentials
  static final String USER = "sa";
  static final String PASS = "sa";

  Connection conn;
  Statement stmt;

  public GestionBD() {
    conn = null;
    stmt = null;
  }

  public void connect() {
    try {
      Class.forName(JDBC_DRIVER).newInstance();
      this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

    } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public void disconnect() {
    try {
      if (stmt != null) stmt.close();
    } catch (SQLException ignored) {
      ignored.printStackTrace();
    }
    try {
      if (conn != null) conn.close();
    } catch (SQLException se) {
      se.printStackTrace();
    }
  }

  public void endConnection() {
    this.connect();
    try {
      PreparedStatement preparedStatement = this.conn.prepareStatement(
          "DROP Table IF EXISTS CERCLE;" +
              "DROP TABLE IF EXISTS CARRE;" +
              "DROP TABLE IF EXISTS TRIANGLE;" +
              "DROP TABLE IF EXISTS RECTANGLE;" +
              "DROP TABLE IF EXISTS GROUPE");
      int resultSet = preparedStatement.executeUpdate();
      preparedStatement.close();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
  }

  public void initConnection() {
    this.connect();
    CercleDAO cercleDAO = new CercleDAO();
    cercleDAO.createTable();
    CarreDAO carreDAO = new CarreDAO();
    carreDAO.createTable();
    RectangleDAO rectangleDAO = new RectangleDAO();
    rectangleDAO.createTable();
    TriangleDAO triangleDAO = new TriangleDAO();
    triangleDAO.createTable();
    CompositeFormeDAO compositeFormeDAO = new CompositeFormeDAO();
    compositeFormeDAO.createTable();
    this.disconnect();
  }

}

