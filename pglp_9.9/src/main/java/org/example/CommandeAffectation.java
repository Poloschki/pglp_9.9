package org.example;

import java.util.ArrayList;

public class CommandeAffectation extends Commande {
  private String name;
  private String type;
  private ArrayList<Double> value = new ArrayList<>();

  public CommandeAffectation(Interpreteur interpreteur) {
    super.interpreteur = interpreteur;
  }

  public void executeCercle() {
    try {

      Cercle c = new Cercle(this.name, value.get(0), value.get(1), value.get(2));
      CercleDAO cDAO = new CercleDAO();
      Cercle c2 = cDAO.find(this.name);
      if (c2 == null) {
        cDAO.create(c);
        super.interpreteur.add(c);
      } else {
        printErrorNameTaken();
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    } catch (IndexOutOfBoundsException i) {
      printErrorNullPointer();
    }
  }

  public void executeTriangle() {
    try {
      Triangle t = new Triangle(this.name, value.get(0), value.get(1), value.get(2), value.get(3), value.get(4), value.get(5));
      TriangleDAO dao = new TriangleDAO();
      Triangle t2 = dao.find(this.name);
      if (t2 == null) {
        dao.create(t);
        super.interpreteur.add(t);
      } else {
        printErrorNameTaken();
      }


    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    }
  }

  public void executeCarre() {
    try {
      Carre carre = new Carre(this.name, value.get(0), value.get(1), value.get(2));
      CarreDAO carreDAO = new CarreDAO();
      Carre c1 = carreDAO.find(this.name);
      if (c1 == null) {
        carreDAO.create(carre);
        super.interpreteur.add(carre);
      } else {
        printErrorNameTaken();
      }

    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    }
  }

  public void excuteRectangle() {
    try {
      Rectangle rect = new Rectangle(this.name, value.get(0), value.get(1), value.get(2), value.get(3));
      RectangleDAO dao = new RectangleDAO();
      Rectangle r1 = dao.find(this.name);
      if (r1 == null) {
        dao.create(rect);
        super.interpreteur.add(rect);
      } else printErrorNameTaken();

    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorArgument();
    } catch (NumberFormatException n) {
      printErrorNumber(n);
    }
  }

  @Override
  public void execute() {
    value = parseStringtoDouble(readValues);
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
    }
    try {
      System.out.println(super.interpreteur.compositeArrayList.get(super.interpreteur.compositeArrayList.size() - 1));
    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorForme();
    }
  }

  @Override
  public void cutting() {
    System.out.println(super.toExecute);
    this.name = super.toExecute.substring(0, super.toExecute.indexOf("="))
        .replaceAll(" ", "");

    this.type = super.toExecute.substring(super.toExecute.indexOf("=") + 1, super.toExecute.indexOf("("))
        .replaceAll(" ", "")
        .toLowerCase();

    this.readValues = super.toExecute.substring(super.toExecute.indexOf("(") + 1)
        .replaceAll("\\(", "")
        .replaceAll("\\)", "")
        .replaceAll(" ", "")
        .split(",");

  }

}
