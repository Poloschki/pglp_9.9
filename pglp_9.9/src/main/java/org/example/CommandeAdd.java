package org.example;

public class CommandeAdd extends Commande {

  public CommandeAdd(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    try {
      Composite composite = interpreteur.getComposite(this.name);
      if (composite == null) {
        //on crée le compositeForme si il n'existe pas
        this.interpreteur.add(new CompositeForme(this.name));
        composite = interpreteur.getComposite(this.name);
        if (composite instanceof CompositeForme) {
          ((CompositeForme) composite).add(this.interpreteur.getComposite(this.readValues[1]));
          composite.print();
        }
      } else {
        composite = interpreteur.getComposite(this.name);
        if (composite instanceof CompositeForme) {
          ((CompositeForme) composite).add(this.interpreteur.getComposite(this.readValues[1]));
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
    this.readValues = this.toExecute.replaceAll("add", "")
        .replaceAll("\\(", "")
        .replaceAll("\\)", "")
        .replaceAll(" ", "")
        .split(",");
    this.name = this.readValues[0];
  }

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }
}
