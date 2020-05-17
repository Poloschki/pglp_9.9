package org.example.commande;

public class CommandeExit implements CommandeExecute {

  @Override
  public void execute() {
    System.exit(0);
  }

}
