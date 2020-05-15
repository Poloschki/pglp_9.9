package org.example;
import java.util.HashMap;


public class DrawingTUI {
  public HashMap<String, CommandeExecute> createdCommand;
  public Interpreteur interpreteur;

  public DrawingTUI() {
    this.createdCommand = new HashMap<>();
    this.interpreteur = new Interpreteur();
  }

  public void initalisation() {
    this.createdCommand.put("move", new CommandeMove(this.interpreteur));
    this.createdCommand.put("=", new CommandeAffectation(this.interpreteur));
    this.createdCommand.put("exit", new CommandeExit());
    this.createdCommand.put("add", new CommandeAdd(this.interpreteur));
    this.createdCommand.put("print", new CommandePrint(this.interpreteur));
    GestionBD bd = new GestionBD();
    bd.initConnection();

  }

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
