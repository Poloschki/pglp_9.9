package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandeMove extends Commande {

  public CommandeMove(Interpreteur interpreteur) {

    super.interpreteur = interpreteur;

  }

  private void updateDAO(Composite composite) {
    if (composite instanceof Carre) {
      DAO<Carre> carre = DAOFactory.getCarreDAO();
      carre.update((Carre) composite);
    } else if (composite instanceof Cercle) {
      DAO<Cercle> cercle = DAOFactory.getCercleDAO();
      cercle.update((Cercle) composite);
    } else if (composite instanceof CompositeForme) {
      DAO<CompositeForme> forme = DAOFactory.getCompositeFormeDAO();
      forme.update((CompositeForme) composite);
    } else if (composite instanceof Rectangle) {
      DAO<Rectangle> rect = DAOFactory.getRectangleDAO();
      rect.update((Rectangle) composite);
    } else if (composite instanceof Triangle) {
      DAO<Triangle> tri = DAOFactory.getTriangleDAO();
      tri.update((Triangle) composite);
    }
  }

  @Override
  public void execute() {
    try {
      ArrayList<Double> value = parseStringtoDouble(Arrays.copyOfRange(readValues, 1, 3));
      Composite composite = super.interpreteur.getComposite(this.name);

      composite.move(value.get(0), value.get(1));
      composite.print();
      updateDAO(composite);

    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    } catch (NullPointerException | IndexOutOfBoundsException e) {
      printErrorNullPointer();

    }
  }

  @Override
  public void cutting() {
    this.readValues = this.toExecute.replaceAll("move", "")
        .replaceAll("\\(", "")
        .replaceAll("\\)", "")
        .replaceAll(" ", "")
        .split(",");
    this.name = this.readValues[0];
  }

}
