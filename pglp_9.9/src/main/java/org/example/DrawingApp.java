package org.example;

import org.example.commande.CommandeExecute;

import java.util.Scanner;

public class DrawingApp {

  public static void main(String[] args) {

    DrawingApp drawingApp = new DrawingApp();
    drawingApp.run();
  }

  public void run() {
    DrawingTUI tui = new DrawingTUI();
    CommandeExecute commande;
    tui.initalisation();
    instruction();
    Scanner input = new Scanner(System.in);
    while (true) {
      commande = tui.nexCommand(input.nextLine());
      try {
        commande.execute();
      } catch (NullPointerException n) {
        System.err.println("Problème avec l'entrée");
      }

    }

  }

  public void instruction() {
    System.out.println("Pour créer une forme " +
        "nom = forme([coordonnée],[rayon],.. )" +
        "\n" +
        "Cercle((x,y),rayon) " +
        "-----------------------" +
        " Carre((x,y),longueur)" +
        "\n" +
        "Rectangle(xHG, yHG, xBD, yBD)" +
        "-------------- " +
        "Triangle(x1,y1,x2,y2,x3,y3)" +
        "\n" +
        "Pour créer un groupe : " +
        "add(nomDuGroupe,forme ou groupe)" +
        "\n" +
        "Pour les déplacements : " +
        "move(obj,(x,y))" +
        "\n" +
        "Pour afficher les éléments créer : print" +
        "\n" +
        "Pour charger ou supprimer les formes se trouvant dans la base de donnée : load" +
        "\n" +
        "Pour quitter : exit ");
  }
}
