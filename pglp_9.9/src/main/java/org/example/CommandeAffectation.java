package org.example;

public class CommandeAffectation implements Commande {
  Interpreteur interpreteur;
  String toExecute;
  String name;
  String type;
  String[] val;

  public CommandeAffectation(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  public void executeCercle() {
    try {

      double x = Double.parseDouble(this.val[0]);
      double y = Double.parseDouble(this.val[1]);
      double rayon = Double.parseDouble(this.val[2]);

      Cercle c = new Cercle(this.name, x, y, rayon);
      CercleDAO cDAO = new CercleDAO();
      Cercle c2 = cDAO.find(this.name);
      if (c2 == null) {
        cDAO.create(c);
      } else {
        System.out.println("existe déjà");
      }

      this.interpreteur.add(c);
    } catch (IllegalArgumentException e) {
      System.err.println(e);
    }
  }

  public void executeTriangle() {
    try {
      double x1 = Double.parseDouble(this.val[0]);
      double y1 = Double.parseDouble(this.val[1]);
      double x2 = Double.parseDouble(this.val[2]);
      double y2 = Double.parseDouble(this.val[3]);
      double x3 = Double.parseDouble(this.val[4]);
      double y3 = Double.parseDouble(this.val[5]);
      this.interpreteur.add(new Triangle(this.name, x1, y1, x2, y2, x3, y3));

    } catch (IllegalArgumentException e) {
      System.err.println(e);
    }
  }

  public void executeCarre() {
    try {
      double x = Double.parseDouble(this.val[0]);
      double y = Double.parseDouble(this.val[1]);
      double longueur = Double.parseDouble(this.val[2]);
      this.interpreteur.add(new Carre(this.name, x, y, longueur));
    } catch (IllegalArgumentException e) {
      System.err.println(e);
    }
  }

  public void excuteRectangle() {
    try {
      double x1 = Double.parseDouble(this.val[0]);
      double y1 = Double.parseDouble(this.val[1]);
      double x2 = Double.parseDouble(this.val[2]);
      double y2 = Double.parseDouble(this.val[3]);
      this.interpreteur.add(new Rectangle(this.name, x1, y1, x2, y2));
    } catch (IllegalArgumentException e) {
      System.err.println(e);
    }
  }

  @Override
  public void execute() {
    switch (this.type) {
      case "cercle":
        executeCercle();

        break;
      case "triangle":
        executeTriangle();
        break;
      case "carre":
        executeCarre();
        break;
      case "rectangle":
        excuteRectangle();
        break;
      default:
        System.err.println("Forme non reconnus");
    }
    System.out.println(this.interpreteur.compositeArrayList.get(this.interpreteur.compositeArrayList.size() - 1));
  }

  @Override
  public void cutting() {
    int pos1, pos2;
    pos1 = this.toExecute.indexOf("=");
    this.name = this.toExecute.substring(0, pos1);
    this.name = this.name.replaceAll(" ", "");
    pos2 = this.toExecute.indexOf("(");
    this.type = this.toExecute.substring(pos1 + 1, pos2);
    this.type = this.type.replaceAll(" ", "");
    this.type = this.type.toLowerCase();
    this.toExecute = this.toExecute.substring(pos2 + 1);
    this.toExecute = this.toExecute.replaceAll("\\(", "");
    this.toExecute = this.toExecute.replaceAll("\\)", "");
    this.val = this.toExecute.split(",");
  }

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }
}
