package org.example.commande;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandeAddTest {

  @Test
  public void cutting() {
    Interpreteur inter = new Interpreteur();
    CommandeAdd add = new CommandeAdd(inter);
    add.toExecute = "add(      er       ,         de";
    add.cutting();
    assertEquals("er", add.readValues[0]);
    assertEquals("de", add.readValues[1]);
    assertEquals("er", add.name);
  }

  @Test
  public void cutting2() {
    Interpreteur inter = new Interpreteur();
    CommandeAdd add = new CommandeAdd(inter);
    add.toExecute = "add( (((  ((  )))(( nom  ))())()()()     ,()()())()()))))(((    ((     tomove123";
    add.cutting();
    assertEquals("nom", add.readValues[0]);
    assertEquals("tomove123", add.readValues[1]);
    assertEquals("nom", add.name);
  }

}