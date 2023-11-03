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
public class SimpleFruitTest {
    SimpleFruit fruit;

    @Before
    public void setUp() {
        fruit = new SimpleFruit(2.0, "France");
    }

   public void tearDown() {
        fruit = null;
    }

    @Test
    public void testGetPrix() {
        assertEquals(2.0, fruit.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("France", fruit.getOrigine());
    }

       
}
