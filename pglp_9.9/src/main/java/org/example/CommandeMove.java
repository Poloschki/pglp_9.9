package org.example;

public class CommandeMove implements Commande {

  Interpreteur interpreteur;
  String toExecute;
  String name;
  String[] val;

  public CommandeMove(Interpreteur interpreteur) {

    this.interpreteur = interpreteur;

  }

  @Override
  public void execute() {
    try {
      double x = Double.parseDouble(this.val[1]);
      double y = Double.parseDouble(this.val[2]);
      Composite composite = interpreteur.getComposite(this.name);

      composite.move(x, y);
      composite.print();

    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }

  @Override
  public void cutting() {
    this.toExecute = this.toExecute.replaceAll("move", "");
    this.toExecute = this.toExecute.replaceAll("\\(", "");
    this.toExecute = this.toExecute.replaceAll("\\)", "");
    this.val = this.toExecute.split(",");
    this.name = this.val[0];
  }

  @Override
  public String toString() {
    return "CommandeMove{" +
        "interpreteur=" + interpreteur +
        ", toExecute='" + toExecute + '\'' +
        '}';
  }
}
