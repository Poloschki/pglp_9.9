package org.example.commande;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandeLoadTest {

  @Test
  public void readInput() {
    Interpreteur inter = new Interpreteur();
    CommandeLoad cl = new CommandeLoad(inter);
    assertTrue(cl.readInput("YES"));
    assertTrue(cl.readInput("yEs"));
    assertTrue(cl.readInput("        sqfdf  yes cdsfcd "));
    assertTrue(cl.readInput(" OUI  "));
    assertTrue(cl.readInput("o"));
    assertFalse(cl.readInput("no "));
    assertFalse(cl.readInput("NFefrfr"));
  }
}