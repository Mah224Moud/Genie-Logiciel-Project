/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.model;
<<<<<<< HEAD
import org.junit.Test;
import static org.junit.Assert.*;
=======
import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
/**
 *
 * @author cristanemir
 */
public class ModeleTest {
<<<<<<< HEAD

    @Test
    public void testConstructor() {
        Modele modele = new Modele();
        assertEquals(0, modele.getCompteur());
        assertEquals("", modele.getInfo());
=======
  private Modele modele;

    @Before
    public void setUp() {
        modele = new Modele();
>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
    }

    @Test
    public void testUpdate() {
<<<<<<< HEAD
        Modele modele = new Modele();
        modele.update(5);
        assertEquals(5, modele.getCompteur());
        modele.update(-3);
        assertEquals(2, modele.getCompteur());
=======
        modele.update(5);
        assertEquals(5, modele.getCompteur());

        modele.update(-3);
        assertEquals(2, modele.getCompteur());

        modele.update(0);
        assertEquals(2, modele.getCompteur());

>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
    }

    @Test
    public void testReset() {
<<<<<<< HEAD
        Modele modele = new Modele();
        modele.update(10);
=======
        modele.update(5);
>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
        modele.reset();
        assertEquals(0, modele.getCompteur());
    }

    @Test
<<<<<<< HEAD
    public void testGetInfo() {
        Modele modele = new Modele();
        assertEquals("", modele.getInfo());
        modele.setInfo("Country");
        assertEquals("L'origine que avez saisie est invalide !!!", modele.getInfo());
    }

    @Test
    public void testAddObserver() {
        Modele modele = new Modele();
        
        int[] changeCount = {0};
        
        modele.addObserver(evt -> {
            assertEquals("value", evt.getPropertyName());
            changeCount[0]++;
        });
        
        modele.update(5);
        assertEquals(1, changeCount[0]);
    }

    @Test
    public void testGetCompteur() {
        Modele modele = new Modele();
        assertEquals(0, modele.getCompteur());
        modele.update(5);
        assertEquals(5, modele.getCompteur());
    }
    
    @Test
    public void testSetPanier() {
        Modele modele = new Modele();
        modele.setPanier(20);
        assertNotNull(modele.getPanier());
=======
    public void testSetPanier() {
        modele.setPanier(10);
        assertNotNull(modele.getPanier());
        assertEquals(10, modele.getPanier().getContenanceMax());
>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
    }

    @Test
    public void testGetPanier() {
<<<<<<< HEAD
        Modele modele = new Modele();
        modele.setPanier(20);
        assertNotNull(modele.getPanier());
=======
        modele.setPanier(10);
        assertNotNull(modele.getPanier());
        assertEquals(10, modele.getPanier().getContenanceMax());
>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
    }

    @Test
    public void testGetPanierList() {
<<<<<<< HEAD
        Modele modele = new Modele();
        assertNotNull(modele.getPanierList());
    }

    @Test
    public void testSetCompteur() {
        Modele modele = new Modele();
        modele.setCompteur(5);
        assertEquals(5, modele.getCompteur());
        modele.setCompteur(-3);
        assertEquals(0, modele.getCompteur());
=======
        assertEquals(0, modele.getPanierList().size());
>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
    }

    @Test
    public void testSetInfo() {
<<<<<<< HEAD
        Modele modele = new Modele();
        modele.setInfo("Country");
        assertEquals("L'origine que avez saisie est invalide !!!", modele.getInfo());
        modele.setInfo("Price");
        assertEquals("Le prix que avez saisie est invalide !!!", modele.getInfo());
        modele.setInfo("Country and price");
        assertEquals("L'origine et le prix sont obligatoires !!!", modele.getInfo());
        modele.setInfo("Other");
        assertEquals("Other a été boycotté", modele.getInfo());
    }
}


=======
        modele.setInfo("");
        assertEquals("", modele.getInfo());

        modele.setInfo("Choisissez un pays");
        assertEquals("Vous n'avez sélectionné aucun pays !!!", modele.getInfo());

        modele.setInfo("Choisissez un fruit");
        assertEquals("Vous n'avez sélectionné aucun fruit !!!", modele.getInfo());

        modele.setInfo("Belgique");
        assertEquals("Belgique a été boycotté", modele.getInfo());

        modele.setInfo("Allemagne");
        assertEquals("Allemagne a été boycotté", modele.getInfo());
    }

    @Test
    public void testSetCompteur() {
        modele.setCompteur(5);
        assertEquals(5, modele.getCompteur());

        modele.setCompteur(-3);
        assertEquals(0, modele.getCompteur());

        modele.setCompteur(0);
        assertEquals(0, modele.getCompteur());
    }
}

>>>>>>> 9a7f45224381b37862f8ff132c1724207f95402f
