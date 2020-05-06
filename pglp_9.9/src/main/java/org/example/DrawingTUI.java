package org.example;
import java.util.HashMap;


public class DrawingTUI {
  public HashMap<String, Commande> createdCommand;
  public Interpreteur interpreteur;

  public DrawingTUI() {
    this.createdCommand = new HashMap<>();
    this.interpreteur = new Interpreteur();
  }

  public void initalisation() {
    this.createdCommand.put("move", new CommandeMove(this.interpreteur));

  }

  public Commande nexCommand(String input) {
    for (String testKey : this.createdCommand.keySet()) {
      if (input.contains(testKey)) {
        Commande commande = this.createdCommand.get(testKey);
        commande.setToExecute(input);
        commande.cutting();
        return commande;

      }
    }
    return null;
  }

}
