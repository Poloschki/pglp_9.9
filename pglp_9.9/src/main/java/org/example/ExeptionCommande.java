package org.example;

public class ExeptionCommande {

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

}
