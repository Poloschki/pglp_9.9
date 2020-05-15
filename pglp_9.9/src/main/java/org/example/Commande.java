package org.example;

import java.util.ArrayList;

public abstract class Commande extends ExeptionCommande implements CommandeExecute {
  protected String[] readValues;
  protected Interpreteur interpreteur;
  protected String toExecute;
  protected String name;


  public ArrayList<Double> parseStringtoDouble(String[] list) {
    ArrayList<Double> afterParse = new ArrayList<>();
    for (String s : list) {
      try {
        afterParse.add(Double.parseDouble(s));
      } catch (ArrayIndexOutOfBoundsException e) {
        printErrorArgument();
      } catch (NumberFormatException n) {
        printErrorNumber(n);
      }
    }
    return afterParse;
  }

  @Override
  public abstract void execute();

  public abstract void cutting();

  public void setToExecute(String string) {
    this.toExecute = string;
  }


}
