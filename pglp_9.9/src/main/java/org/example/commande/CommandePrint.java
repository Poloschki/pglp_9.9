package org.example.commande;

public class CommandePrint implements CommandeExecute {

  Interpreteur interpreteur;

  public CommandePrint(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    for (int i = 0; i < this.interpreteur.compositeArrayList.size(); i++) {
      this.interpreteur.compositeArrayList.get(i).print();
    }
  }

  @Override
  public void instruction() {
    System.out.println("print --> Permet d'afficher le contenus local");
  }

}
