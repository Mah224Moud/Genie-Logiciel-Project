
package fr.ufrsciencestech.utils;

import fr.ufrsciencestech.panier.*;
import java.util.ArrayList;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


/**
 *
 * @author cristanemir
 */
public class PanierTest {
    


    Panier p;

    public PanierTest() {
        p = new Panier(3);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   
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
    public void testGetPrix() throws PanierPleinException {
   
    double expResult = 0.0;
    double result = p.getPrix(); //test avec la DT1 de getPrix
    assertTrue(expResult == result); //oracle
    //panier à un element à 0.50
    Orange o1 = new Orange(0.50, "Espagne");
    p.ajout(o1);
    double expResult2 = 0.50;
    double result2 = p.getPrix(); 
    assertTrue(expResult2 == result2);
    //panier ou il reste une place
    Orange o2 = new Orange(1.0, "France");
    p.ajout(o2);
    double expResult3 = 1.50;
    double result3 = p.getPrix(); //test avec la DT3 de getPrix
    assertTrue(expResult3 == result3);
    //panier plein
    Orange o3 = new Orange(1.5, "Italie");
    p.ajout(o3);
    double expResult4 = 3.0;
    double result4 = p.getPrix(); //test avec la DT4 de getPrix
    assertTrue(expResult4 == result4);
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
        p.setContenanceMax(10);
        // voir si la contenance est de 10 ou de 1 pour le panier
        assertTrue(p.getContenanceMax() == 10);
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
