package org.example;

import java.util.Scanner;

public class DrawingApp {

  public static void main(String[] args) {

    DrawingApp drawingApp = new DrawingApp();
    drawingApp.run();
  }

  public void run() {
    DrawingTUI tui = new DrawingTUI();
    Commande commande;
    tui.initalisation();
    instruction();
    Scanner input = new Scanner(System.in);
    while (true) {
      commande = tui.nexCommand(input.nextLine());
      commande.execute();
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
        "Pour quitter : exit ");
  }
}

/**
 * TODO
 * une commande print qui affiche tous les éléments se trouvant dans la liste de interpréteur
 */