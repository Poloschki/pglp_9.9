package org.example;

public class CommandeAdd extends Commande {
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
          ((CompositeForme) composite).add(this.interpreteur.getComposite(this.val[1]));
          composite.print();
        }
      } else {
        composite = interpreteur.getComposite(this.name);
        if (composite instanceof CompositeForme) {
          ((CompositeForme) composite).add(this.interpreteur.getComposite(this.val[1]));
          composite.print();
        }

      }
    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    } catch (NullPointerException n) {
      printErrorNullPointer();
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

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }
}
