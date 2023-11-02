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
public class MangueTest {
    Mangue m;

    @Before
    public void setUp() {
        m = new Mangue(1.5, "Honduras");
    }

    @Test
    public void testGetPrix() {
        assertEquals(1.5, m.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Honduras", m.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Mangue du Honduras à 1.5 €", m.toString());
    }

    @Test
    public void testIsSeedless() {
        assertFalse(m.isSeedless());
    }

    @Test
    public void testEquals() {
        Mangue mangue1 = new Mangue(1.5, "Honduras");
        Mangue mangue2 = new Mangue(2.0, "Thaïlande");

        assertTrue(m.equals(mangue1));
        assertFalse(m.equals(mangue2));
    }
}
