package org.example.commande;

import org.example.figure.*;

public class CommandeAdd extends Commande {

  public CommandeAdd(Interpreteur interpreteur) {
    super.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    try {
      Composite composite = super.interpreteur.getComposite(this.name);
      if (composite == null) {
        //on crée le compositeForme si il n'existe pas
        super.interpreteur.add(new CompositeForme(this.name));
        composite = super.interpreteur.getComposite(this.name);
        if (composite instanceof CompositeForme) {
          ((CompositeForme) composite).add(super.interpreteur.getComposite(this.readValues[1]));
          DAO<CompositeForme> cfDAO = DAOFactory.getCompositeFormeDAO();
          cfDAO.create((CompositeForme) composite);
          composite.print();
        }
      } else {
        composite = super.interpreteur.getComposite(this.name);
        if (composite instanceof CompositeForme) {
          ((CompositeForme) composite).add(super.interpreteur.getComposite(this.readValues[1]));
          CompositeFormeDAO cfDAO = new CompositeFormeDAO();
          cfDAO.create((CompositeForme) composite);
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
    this.readValues = super.toExecute.replaceAll("add", "")
        .replaceAll("\\(", "")
        .replaceAll("\\)", "")
        .replaceAll(" ", "")
        .split(",");
    this.name = this.readValues[0];
  }

}
