/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author cristanemir
 */
public class VueGraphSwingTest {
    


    private VueGraphSwing vue;
     @Before
     
    public void setUp() {
        //Initialisation de la classe de test avant chaque test
        vue = new VueGraphSwing();
    }
    

    @Test
    public void testGetInc() {
        // Vérification que le bouton "inc" est correctement initialisé
        JButton inc = vue.getInc();
        assertNotNull(inc);
        assertEquals("+", inc.getText());
    }

    @Test
    public void testGetDec() {
         // Vérification que le bouton "dec" est correctement initialisé
        JButton dec = vue.getDec();
        assertNotNull(dec);
        assertEquals("-", dec.getText());
    }

    @Test
    public void testGetReset() {
         // Vérification que le bouton "reset" est correctement initialisé
        JButton reset = vue.getReset();
        assertNotNull(reset);
        assertEquals("Vider le panier", reset.getText());
    }

    @Test
    public void testGetBoycotte() {
         // Vérification que le bouton "Boycotte" est correctement initialisé
        JButton boycotte = vue.getBoycotte();
        assertNotNull(boycotte);
        assertEquals("Boycotter", boycotte.getText());
    }

    @Test
    public void testGetAffiche() {
        // Vérification que l'étiquette "compteur" est correctement initialisée
        JLabel compteur = vue.getAffiche();
        assertNotNull(compteur);
        assertEquals("0", compteur.getText());
    }

    @Test
    public void testGetPanierList() {
        // Vérification que la liste déroulante "panierList" est correctement initialisée
        JComboBox panierList = vue.getPanierList();
        assertNotNull(panierList);
        assertEquals(0, panierList.getItemCount());
    }

    @Test
    public void testGetShow() {
        // Vérification que la zone de texte "show" est correctement initialisée
        JTextArea show = vue.getShow();
        assertNotNull(show);
        assertFalse(show.isEditable());
    }

    @Test
    public void testGetCountryList() {
         // Vérification que la liste déroulante "countryList" est correctement initialisée
        JComboBox countryList = vue.getCountryList();
        assertNotNull(countryList);
        assertEquals(0, countryList.getItemCount());
    }

    @Test
    public void testGetFruit() {
        JMenuItem createFruit = vue.getFruit();
        assertNotNull(createFruit);
        assertEquals("Créer un fruit", createFruit.getText());
    }

    @Test
    public void testGetQuit() {
         // Vérification que l'élément de menu "quit" est correctement initialisé
        JMenuItem quit = vue.getQuit();
        assertNotNull(quit);
        assertEquals("Quitter", quit.getText());
    }

    @Test
    public void testGetNewPanier() {
         // Vérification que l'élément de menu "newPanier" est correctement initialisé
        JMenuItem newPanier = vue.getNewPanier();
        assertNotNull(newPanier);
        assertEquals("Créer un panier", newPanier.getText());
    }
}
