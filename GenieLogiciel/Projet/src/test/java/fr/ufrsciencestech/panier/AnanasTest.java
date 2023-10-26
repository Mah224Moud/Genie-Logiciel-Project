/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import fr.ufrsciencestech.panier.Ananas;
package fr.ufrsciencestech.panier;


public class AnanasTest {
    Ananas ananas;

    @Before
    public void setUp() {
        ananas = new Ananas(0.5, "Brésil");
    }
     @Test
    public void testGetPrix() {
        assertEquals(0.5, ananas.getPrix(), 0.0);
    }
    @Test
    public void testGetOrigine() {
        assertEquals("Brésil", ananas.getOrigine());
    }
     @Test
    public void testToString() {
        assertEquals("Ananas du Brésil à 0.5 €", ananas.toString());
    }
     @Test
    public void testIsSeedless() {
        assertFalse(ananas.isSeedless());
    }
    @Test
    public void testEquals() {
        Ananas Ananas1 = new Ananas(0.5, "Brésil");
        Ananas Ananas2 = new Ananas(0.7, "Costa Rica");

        assertTrue(ananas.equals(Ananas1));
        assertFalse(ananas.equals(Ananas2));
    }
}
