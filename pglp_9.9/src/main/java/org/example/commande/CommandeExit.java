package org.example.commande;

public class CommandeExit implements CommandeExecute {

  @Override
  public void execute() {
    System.exit(0);
  }

  @Override
  public void instruction() {
    System.out.println("exit --> Permet de quitter le programme");
  }

}
