/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.utils;

import fr.ufrsciencestech.panier.*;
import java.util.ArrayList;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author cristanemir
 */
public class PanierTest {
    Panier p;

    public PanierTest() {
        p = new Panier(10);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Banane.
     */
    @Test
    public void testGetFruits() {
        System.out.println("getFruits");
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        assertTrue(p.getFruits().equals(fruits));
    }

    @Test
    public void testSetFruits() {
        System.out.println("setFruits");
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        p.setFruits(fruits);
        assertTrue(p.getFruits().equals(fruits));

        //test si depassement contenance max
        p.setContenanceMax(1);
        ArrayList<Fruit> fruits2 = new ArrayList<Fruit>();
        fruits2.add(new Banane());
        fruits2.add(new Cerise());
        p.setFruits(fruits2);
        assertTrue(p.getTaillePanier() == fruits2.size());
    }

    @Test
    public void testGetTaillePanier() {
        System.out.println("getTaillePanier");
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        assertTrue(p.getTaillePanier() == fruits.size());
    }

    @Test
    public void testGetContenanceMax() {
        System.out.println("getContenanceMax");
        int contenanceMax = 10;
        // voir si la contenance est de 10 ou de 1 pour le panier
        assertTrue(p.getContenanceMax() == contenanceMax);
    }

    @Test
    public void testSetFruit() {
        System.out.println("setFruit");
        try {
            p.ajout(new Banane());
        } catch (PanierPleinException ex) {
            System.out.println(ex);
            assertTrue(false);
        }
        int taillePanierAvant = p.getTaillePanier();
        p.setFruit(0, new Cerise());
        assertTrue(p.getTaillePanier() == taillePanierAvant);
    }

    @Test
    public void testEstVide() {
        System.out.println("estVide ?");
        assertTrue(p.estVide());
    }

    @Test
    public void testEstPlein() {
        System.out.println("estPlein ?");
        p.setContenanceMax(1);

        try {
            p.ajout(new Banane());
        } catch (PanierPleinException e) {
            System.out.println(e);
            assertTrue(false);
        }

        assertTrue(p.estPlein());
    }

    @Test
    public void testAjout() {
        System.out.println("Test ajout");
        int pSize = p.getTaillePanier();
        try {
            p.ajout(new Banane());
        } catch (PanierPleinException ex) {
            System.out.println(ex);
            assertTrue(false);
        }
        assertTrue(p.getTaillePanier() == pSize + 1);
    }

    @Test
    public void testRetrait() {
        System.out.println("Test ajout");
        Panier p2 = new Panier(10);
        try {
            p2.ajout(new Banane());
            p2.retrait();
        } catch (PanierPleinException | PanierVideException ex) {
            System.out.println(ex);
            assertTrue(false);
        }
        assertTrue(p2.getTaillePanier() == 0);
    }

    @Test
    public void testEquals() {
        System.out.println("Equals");
        Panier p2 = new Panier(1);
        Panier p3 = new Panier(1);
        try {
            p2.ajout(new Banane());
            p3.ajout(new Banane());

        } catch (PanierPleinException ex) {
            System.out.println(ex);
            assertTrue(false);
        }

      
        assertTrue(p3.equals(p2));
    }

}
