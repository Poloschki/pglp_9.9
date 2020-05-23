package org.example;

import java.util.HashMap;
import org.example.commande.Commande;
import org.example.commande.CommandeAdd;
import org.example.commande.CommandeAffectation;
import org.example.commande.CommandeExecute;
import org.example.commande.CommandeExit;
import org.example.commande.CommandeLoad;
import org.example.commande.CommandeMove;
import org.example.commande.CommandePrint;
import org.example.commande.Interpreteur;


public class DrawingTUI {
  public HashMap<String, CommandeExecute> createdCommand;
  public Interpreteur interpreteur;

  public DrawingTUI() {
    this.createdCommand = new HashMap<>();
    this.interpreteur = new Interpreteur();
  }

  /**
   * Initialise les commandes accessible à l'utilisateur.
   */
  public void initalisation() {
    this.createdCommand.put("move", new CommandeMove(this.interpreteur));
    this.createdCommand.put("=", new CommandeAffectation(this.interpreteur));
    this.createdCommand.put("add", new CommandeAdd(this.interpreteur));
    this.createdCommand.put("print", new CommandePrint(this.interpreteur));
    this.createdCommand.put("exit", new CommandeExit());
    this.createdCommand.put("load", new CommandeLoad(this.interpreteur));
  }

  /**
   * À partir de l'entrée de l'utilisateur on retourne la commande saisie.
   *
   * @param input entrée de l'utilisateur.
   * @return la commande compris.
   */
  public CommandeExecute nexCommand(String input) {
    for (String testKey : this.createdCommand.keySet()) {
      if (input.contains(testKey)) {
        CommandeExecute commande = this.createdCommand.get(testKey);
        if (commande instanceof Commande) {
          ((Commande) commande).setToExecute(input);
          ((Commande) commande).cutting();

        }
        return commande;

      }
    }
    return null;
  }

}
