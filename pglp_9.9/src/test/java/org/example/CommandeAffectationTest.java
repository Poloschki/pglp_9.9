package org.example;

import org.junit.Before;
import org.junit.Test;

public class CommandeAffectationTest {
  Interpreteur inter;
  CommandeAffectation ca;

  @Before
  public void init() {
    inter = new Interpreteur();
    ca = new CommandeAffectation(inter);
  }

  @Test
  public void executeCercle() {
    ca.setToExecute("c = cercle((3,3),3)");
    ca.cutting();
    ca.executeCercle();
  }


  @Test
  public void executeTriangle() {
  }

  @Test
  public void executeCarre() {
  }

  @Test
  public void excuteRectangle() {
  }

  @Test
  public void execute() {
  }

  @Test
  public void cutting() {
  }

  @Test
  public void setToExecute() {
  }
}