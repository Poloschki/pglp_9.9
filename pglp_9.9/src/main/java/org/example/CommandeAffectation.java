package org.example;

import java.util.ArrayList;

public class CommandeAffectation extends Commande {
  private final Interpreteur interpreteur;
  private String toExecute;
  private String name;
  private String type;
  private ArrayList<Double> value = new ArrayList<>();

  public CommandeAffectation(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  public void executeCercle() {
    try {

      Cercle c = new Cercle(this.name, value.get(0), value.get(1), value.get(2));
      CercleDAO cDAO = new CercleDAO();
      Cercle c2 = cDAO.find(this.name);
      if (c2 == null) {
        cDAO.create(c);
        this.interpreteur.add(c);
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
        this.interpreteur.add(t);
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
        this.interpreteur.add(carre);
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
        this.interpreteur.add(rect);
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
      System.out.println(this.interpreteur.compositeArrayList.get(this.interpreteur.compositeArrayList.size() - 1));
    } catch (ArrayIndexOutOfBoundsException e) {
      printErrorForme();
    }
  }

  @Override
  public void cutting() {
    this.name = this.toExecute.substring(0, this.toExecute.indexOf("=")).replaceAll(" ", "");

    this.type = this.toExecute.substring(this.toExecute.indexOf("=") + 1, this.toExecute.indexOf("("))
        .replaceAll(" ", "")
        .toLowerCase();

    this.readValues = this.toExecute.substring(this.toExecute.indexOf("(") + 1)
        .replaceAll("\\(", "")
        .replaceAll("\\)", "")
        .replaceAll(" ", "")
        .split(",");

  }

  @Override
  public void setToExecute(String input) {
    this.toExecute = input;
  }
}
