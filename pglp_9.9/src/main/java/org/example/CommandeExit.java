package org.example;

public class CommandeExit implements CommandeExecute {

  @Override
  public void execute() {
    //  GestionBD bd = new GestionBD();
    // bd.endConnection();
    System.exit(0);
  }

}
