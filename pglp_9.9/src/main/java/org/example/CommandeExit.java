package org.example;

public class CommandeExit implements Commande {


  @Override
  public void execute() {
    GestionBD gestionBD = new GestionBD();
    gestionBD.endConnection();
    System.exit(0);
  }

  @Override
  public void cutting() {

  }

  @Override
  public void setToExecute(String input) {

  }
}
