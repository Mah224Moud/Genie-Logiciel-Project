/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.model;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModeleTest {

    @Test
    public void testConstructor() {
        Modele modele = new Modele();
        assertEquals(0, modele.getCompteur());
        assertEquals("", modele.getInfo());
    }

    @Test
    public void testUpdate() {
        Modele modele = new Modele();
        modele.update(5);
        assertEquals(5, modele.getCompteur());
        modele.update(-3);
        assertEquals(2, modele.getCompteur());
    }
    
    @Test
    public void testGetInfo() {
        Modele modele = new Modele();
        assertEquals("", modele.getInfo());
        modele.setInfo("Country");
        assertEquals("L'origine que avez saisie est invalide !!!", modele.getInfo());
    }

    /*@Test
    public void testAddObserver() {
        Modele modele = new Modele();
        
        int[] changeCount = {0};
        
        modele.addObserver(evt -> {
            assertEquals("value", evt.getPropertyName());
            changeCount[0]++;
        });
        
        modele.update(5);
        assertEquals(1, changeCount[0]);
    }*/

    @Test
    public void testGetCompteur() {
        Modele modele = new Modele();
        assertEquals(0, modele.getCompteur());
        modele.update(5);
        assertEquals(5, modele.getCompteur());
    }

    @Test
    public void testReset() {
        Modele modele = new Modele();
        modele.update(10);
        modele.reset();
        assertEquals(0, modele.getCompteur());
    }

    @Test
    public void testSetPanier() {
        Modele modele = new Modele();
        modele.setPanier(20);
        assertNotNull(modele.getPanier());
    }

    @Test
    public void testGetPanier() {
        Modele modele = new Modele();
        modele.setPanier(20);
        assertNotNull(modele.getPanier());
    }

    @Test
    public void testGetPanierList() {
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
    }

    @Test
    public void testSetInfo() {
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

