package org.example;

public abstract class Commande {

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

  public abstract void execute();

  public abstract void cutting();

  public abstract void setToExecute(String input);


}
