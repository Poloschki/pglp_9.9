package org.example.commande;

import java.util.ArrayList;
import java.util.Arrays;
import org.example.figure.Carre;
import org.example.figure.Cercle;
import org.example.figure.Composite;
import org.example.figure.CompositeForme;
import org.example.figure.DAOFactory;
import org.example.figure.Rectangle;
import org.example.figure.Triangle;


public class CommandeMove extends Commande {

  /**
   * Constructeur de la commande Move.
   *
   * @param interpreteur l'interpréteur.
   */
  public CommandeMove(Interpreteur interpreteur) {

    super.interpreteur = interpreteur;

  }

  private void updateDAO(Composite composite) {
    if (composite instanceof Carre) {
      DAOFactory.getCarreDAO().update((Carre) composite);
    } else if (composite instanceof Cercle) {
      DAOFactory.getCercleDAO().update((Cercle) composite);
    } else if (composite instanceof CompositeForme) {
      DAOFactory.getCompositeFormeDAO().update((CompositeForme) composite);
    } else if (composite instanceof Rectangle) {
      DAOFactory.getRectangleDAO().update((Rectangle) composite);
    } else if (composite instanceof Triangle) {
      DAOFactory.getTriangleDAO().update((Triangle) composite);
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
  public void instruction() {
    System.out.println("move(nom_composite, x,y ) --> "
        + "Permet de déplacer le composite selon x et y");
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
