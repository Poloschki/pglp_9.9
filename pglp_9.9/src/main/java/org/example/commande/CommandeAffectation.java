package org.example.commande;

import org.example.figure.*;

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
      DAO<Cercle> cDAO = DAOFactory.getCercleDAO();
      if (cDAO.find(this.name) == null) {
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
      DAO<Triangle> dao = DAOFactory.getTriangleDAO();
      if (dao.find(this.name) == null) {
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
      DAO<Carre> carreDAO = DAOFactory.getCarreDAO();
      if (carreDAO.find(this.name) == null) {
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
      if (dao.find(this.name) == null) {
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
