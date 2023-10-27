/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.model;
import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author cristanemir
 */
public class ModeleTest {
  private Modele modele;

    @Before
    public void setUp() {
        modele = new Modele();
    }

    @Test
    public void testUpdate() {
        modele.update(5);
        assertEquals(5, modele.getCompteur());

        modele.update(-3);
        assertEquals(2, modele.getCompteur());

        modele.update(0);
        assertEquals(2, modele.getCompteur());

    }

    @Test
    public void testReset() {
        modele.update(5);
        modele.reset();
        assertEquals(0, modele.getCompteur());
    }

    @Test
    public void testSetPanier() {
        modele.setPanier(10);
        assertNotNull(modele.getPanier());
        assertEquals(10, modele.getPanier().getContenanceMax());
    }

    @Test
    public void testGetPanier() {
        modele.setPanier(10);
        assertNotNull(modele.getPanier());
        assertEquals(10, modele.getPanier().getContenanceMax());
    }

    @Test
    public void testGetPanierList() {
        assertEquals(0, modele.getPanierList().size());
    }

    @Test
    public void testSetInfo() {
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

