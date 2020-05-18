package org.example;

import org.example.commande.CommandeExecute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DrawingApp {

  /**
   * Main.
   *
   * @param args argument du main.
   */
  public static void main(String[] args) {

    DrawingApp drawingApp = new DrawingApp();
    drawingApp.run();
  }

  /**
   * Permet de lancer l'exécution.
   */
  public void run() {
    DrawingTUI tui = new DrawingTUI();
    CommandeExecute commande;
    tui.initalisation();
    instruction(tui.createdCommand);
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

  /**
   * Affiche les commandes accessible à l'utilisateur.
   *
   * @param listcommande liste des commandes disponible.
   */
  public void instruction(HashMap<String, CommandeExecute> listcommande) {

    for (Map.Entry entry : listcommande.entrySet()) {
      CommandeExecute commandeExecute = (CommandeExecute) entry.getValue();
      commandeExecute.instruction();
    }

  }
}
