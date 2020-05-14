package org.example;

public class CommandePrint extends Commande {

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
  public void cutting() {

  }

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }
}
