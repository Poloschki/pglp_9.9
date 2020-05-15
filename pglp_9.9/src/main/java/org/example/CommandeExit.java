package org.example;

public class CommandeExit implements CommandeExecute {

  @Override
  public void execute() {
    GestionBD gestionBD = new GestionBD();
    gestionBD.endConnection();
    System.exit(0);
  }

}
