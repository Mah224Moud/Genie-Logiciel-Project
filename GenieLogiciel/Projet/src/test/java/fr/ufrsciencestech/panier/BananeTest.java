/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salim1417
 */
public class BananeTest {
    Banane b;
    
    
    @Before
    public void setUp() {
        b = new Banane(0.5, "Espagne");
    }
    
    @After
    public void tearDown() {
        b = null;
    }

    @Test
    public void testGetPrix() {
        assertEquals(0.5, b.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Espagne", b.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Banane de Espagne à 0.5 €", b.toString());
    }

     @Test
    public void testIsSeedless() {
        assertFalse(b.isSeedless());
    }

     @Test
    public void testEquals() {
        Banane banane1 = new Banane(0.5, "Espagne");
        Banane banane2 = new Banane(0.7, "Costa Rica");

        assertTrue(b.equals(banane1));
        assertFalse(b.equals(banane2));
    }

}
