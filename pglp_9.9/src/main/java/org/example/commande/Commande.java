package org.example.commande;

import java.util.ArrayList;

public abstract class Commande extends ExeptionCommande implements CommandeExecute {
  protected String[] readValues;
  protected Interpreteur interpreteur = new Interpreteur();
  protected String toExecute;
  protected String name;


  /**
   * Récupère le tableau du split et parse tous les éléments en double.
   *
   * @param list le tableau donné par le split.
   * @return une arrayList des éléments parsé en double.
   */
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
