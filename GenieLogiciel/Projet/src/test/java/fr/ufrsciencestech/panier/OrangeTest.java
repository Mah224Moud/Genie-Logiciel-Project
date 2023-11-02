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
public class OrangeTest {
    Orange o;

    @Before
    public void setUp() {
        o = new Orange(0.9, "Etats Unies");
    }

    @Test
    public void testGetPrix() {
        assertEquals(0.9, o.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Etats Unies", o.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Orange des Etats Unies à 0.9 €", o.toString());
    }

    @Test
    public void testIsSeedless() {
        assertFalse(o.isSeedless());
    }

    @Test
    public void testEquals() {
        Orange orange1 = new Orange(0.9, "Etats Unies");
        Orange orange2 = new Orange(1.0, "France");

        assertTrue(o.equals(orange1));
        assertFalse(o.equals(orange2));
    }
