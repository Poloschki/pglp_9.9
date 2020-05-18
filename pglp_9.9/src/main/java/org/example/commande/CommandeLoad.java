package org.example.commande;

import org.example.figure.DAOFactory;
import org.example.figure.GestionBD;

import java.util.Scanner;


public class CommandeLoad extends Commande {

  public CommandeLoad(Interpreteur interpreteur) {
    super.interpreteur = interpreteur;
  }

  /**
   * Permet de récupérer le contenus de la base de donnée
   * et l'enregistrer dans l'interpréteur.
   */
  public void recupereBD() {
    System.out.println("Récupération BD");
    super.interpreteur.removeAll();
    super.interpreteur.addAll((DAOFactory.getCercleDAO().findAll()));
    super.interpreteur.addAll(DAOFactory.getCarreDAO().findAll());
    super.interpreteur.addAll(DAOFactory.getRectangleDAO().findAll());
    super.interpreteur.addAll(DAOFactory.getTriangleDAO().findAll());
    System.out.println(super.interpreteur.toString());
  }

  /**
   * Permet de réinitialiser le contenus de la base de donnée.
   */
  public void supprimerBD() {
    System.out.println("Supression BD");
    GestionBD bd = new GestionBD();
    bd.endConnection();
    bd.initConnection();
  }

  /**
   * Permet de savoir si l'utilisateur veut récuperer le contenus
   * de la base de donnée ou non.
   *
   * @param string la réponse de l'utilisateur.
   * @return booléan selon l'entrée.
   */
  public boolean readInput(String string) {
    return string.toLowerCase().contains("y")
        || string.toLowerCase().replaceAll(" ", "").matches("oui")
        || string.toLowerCase().startsWith("o");
  }


  @Override
  public void execute() {
    Scanner input = new Scanner(System.in);
    System.out.println("Voulez-vous récupérer le contenus de la BD ?"
        + " [Y/N] Dans le cas contraire elle sera vidé");
    if (readInput(input.nextLine())) {
      recupereBD();
    } else {
      supprimerBD();
    }
    System.out.println("Toutes les nouvelles formes sont enregistres dans la base de donnée");
  }

  @Override
  public void cutting() {
  }

}
