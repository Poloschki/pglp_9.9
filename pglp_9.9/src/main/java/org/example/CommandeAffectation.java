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

  public void printError() {
    System.out.println("Le nom est déjà occupé");
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
        this.interpreteur.add(c);
      } else {
        printError();
      }


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

      Triangle t = new Triangle(this.name, x1, y1, x2, y2, x3, y3);
      TriangleDAO dao = new TriangleDAO();
      Triangle t2 = dao.find(this.name);
      if (t2 == null) {
        dao.create(t);
        this.interpreteur.add(new Triangle(this.name, x1, y1, x2, y2, x3, y3));
      } else {
        printError();
      }


    } catch (IllegalArgumentException e) {
      System.err.println(e);
    }
  }

  public void executeCarre() {
    try {
      double x = Double.parseDouble(this.val[0]);
      double y = Double.parseDouble(this.val[1]);
      double longueur = Double.parseDouble(this.val[2]);

      Carre carre = new Carre(this.name, x, y, longueur);
      CarreDAO carreDAO = new CarreDAO();
      Carre c1 = carreDAO.find(this.name);
      if (c1 == null) {
        carreDAO.create(carre);
        this.interpreteur.add(carre);
      } else {
        printError();
      }

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

      Rectangle rect = new Rectangle(this.name, x1, y1, x2, y2);
      RectangleDAO dao = new RectangleDAO();
      Rectangle r1 = dao.find(this.name);
      if (r1 == null) {
        dao.create(rect);
        this.interpreteur.add(rect);
      } else printError();

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
