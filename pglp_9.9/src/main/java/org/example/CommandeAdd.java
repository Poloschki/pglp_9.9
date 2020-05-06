package org.example;

public class CommandeAdd implements Commande {
  Interpreteur interpreteur;
  String toExecute;
  String name;
  String[] val;

  public CommandeAdd(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    try {
      Composite composite = interpreteur.getComposite(this.name);
      if (composite == null) {
        this.interpreteur.add(new CompositeForme(this.name));
        composite = interpreteur.getComposite(this.name);
        if (composite instanceof CompositeForme) {
          //composite = this.interpreteur.getComposite(this.name);
          ((CompositeForme) composite).add(this.interpreteur.getComposite(this.val[1]));
          composite.print();
        }
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void cutting() {
    this.toExecute = this.toExecute.replaceAll("add", "");
    this.toExecute = this.toExecute.replaceAll("\\(", "");
    this.toExecute = this.toExecute.replaceAll("\\)", "");
    this.val = this.toExecute.split(",");
    this.name = this.val[0];
  }

  //add(g1,c1)
  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }
}
