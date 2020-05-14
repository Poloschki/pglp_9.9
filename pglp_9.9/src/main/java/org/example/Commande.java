package org.example;

import java.util.ArrayList;

public abstract class Commande {
  protected String[] readValues;
  protected Interpreteur interpreteur;
  protected String toExecute;
  protected String name;

  public void printErrorNameTaken() {
    System.err.println("Le nom est déjà occupé");
  }

  public void printErrorArgument() {
    System.err.println("Erreur dans les arguments");
  }

  public void printErrorNumber(NumberFormatException n) {
    System.err.println("Entrée non correct " + n);
  }

  public void printErrorNullPointer() {
    System.err.println("Argument non valide");
  }

  public void printErrorForme() {
    System.err.println("Forme non reconnus ou problèmes dans sa création");
  }

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

  public abstract void execute();

  public abstract void cutting();

  public abstract void setToExecute(String input);


}
