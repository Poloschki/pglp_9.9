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
    Scanner input = new Scanner(System.in);
    while (true) {
      commande = tui.nexCommand(input.nextLine());
      commande.execute();
    }

  }
}
