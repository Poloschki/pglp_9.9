package org.example;

public class CommandeExit implements Commande {


  @Override
  public void execute() {
    System.exit(0);
  }

  @Override
  public void cutting() {

  }

  @Override
  public void setToExecute(String input) {

  }
}
