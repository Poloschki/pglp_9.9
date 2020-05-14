package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandeMove extends Commande {

  public CommandeMove(Interpreteur interpreteur) {

    this.interpreteur = interpreteur;

  }

  @Override
  public void execute() {
    try {
      ArrayList<Double> value = parseStringtoDouble(Arrays.copyOfRange(readValues, 1, 3));
      Composite composite = interpreteur.getComposite(this.name);

      composite.move(value.get(0), value.get(1));
      composite.print();

    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    } catch (NullPointerException | IndexOutOfBoundsException e) {
      printErrorNullPointer();

    }
  }

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
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
