package org.example;

public class DrawingApp {

  public static void main(String[] args) {
    DrawingApp drawingApp = new DrawingApp();
    drawingApp.run();
  }

  public void run() {
    DrawingTUI tui = new DrawingTUI();
    Commande commande;
    tui.initalisation();

    commande = tui.nexCommand("move(c1 , (10,10)");
    commande.execute();

  }
}
/* TODO :
    _ DrawingTUI a la hashMap et retourne les commandes
    _ DrawingApp appel nextCommande de DrawingTUI, celui ci il le scanner et transforme l'objet et le retourne en commande
    _ DrawingApp récupère la commande, excute la commande
    _ affiche la modif effectuer
 */