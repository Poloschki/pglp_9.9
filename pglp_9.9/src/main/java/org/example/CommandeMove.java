package org.example;

public class CommandeMove extends Commande {

  Interpreteur interpreteur;
  String toExecute;
  String name;
  String[] val;

  public CommandeMove(Interpreteur interpreteur) {

    this.interpreteur = interpreteur;

  }

  public void printErrorArgument() {
    System.err.println("Pas assez d'argument");
  }

  public void printErrorNumber(NumberFormatException n) {
    System.err.println("Entrée non correct " + n);
  }

  public void printErrorNullPointer() {
    System.err.println("l'objet à déplacer n'existe pas");
  }

  @Override
  public void execute() {
    try {
      double x = Double.parseDouble(this.val[1]);
      double y = Double.parseDouble(this.val[2]);
      Composite composite = interpreteur.getComposite(this.name);

      composite.move(x, y);
      composite.print();

    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    } catch (NullPointerException e) {
      printErrorNullPointer();
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

}
