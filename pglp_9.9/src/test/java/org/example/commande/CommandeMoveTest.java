package org.example.commande;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandeMoveTest {

  @Test
  public void cutting() {
    Interpreteur inter = new Interpreteur();
    CommandeMove move = new CommandeMove(inter);
    move.toExecute = "    move    (((((())()()()())()(name )()()()())(, 3 ,()(,4";
    move.cutting();
    assertEquals("name", move.name);
  }
}