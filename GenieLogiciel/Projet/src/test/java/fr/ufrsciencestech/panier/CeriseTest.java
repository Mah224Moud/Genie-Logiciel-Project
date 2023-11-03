/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salim1417
 */
public class CeriseTest {
    Cerise c;

    @Before
    public void setUp() {
        c = new Cerise(0.6, "Italie");
    }

    @Test
    public void testGetPrix() {
        assertEquals(0.6, c.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Italie", c.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Cerise de Italie à 0.6 €", c.toString());
    }

    @Test
    public void testIsSeedless() {
        assertFalse(c.isSeedless());
    }

   
}
