/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AnanasTest {
    Ananas a;

    @Before
    public void setUp() {
        a = new Ananas(0.5, "Brésil");
    }

     @After
    public void tearDown() {
        a = null;
    }
    
      @Test
    public void testGetPrix() {
        assertEquals(0.5, a.getPrix(), 0.0);
    }
    
    @Test
    public void testGetOrigine() {
        assertEquals("Brésil", a.getOrigine());
    }
    
    @Test
    public void testToString() {
        assertEquals("Ananas du Brésil à 0.5 €", a.toString());
    }
    
      @Test
    public void testIsSeedless() {
        assertFalse(a.isSeedless());
    }
    
    @Test
    public void testEquals() {
        Ananas ananas1 = new Ananas(0.5, "Brésil");
        Ananas ananas2 = new Ananas(0.7, "Costa Rica");

        assertTrue(a.equals(ananas1));
        assertFalse(a.equals(ananas2));
    }
}
