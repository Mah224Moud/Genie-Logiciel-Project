/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author cristanemir
 */
public class VueGraphSwingTest {

    private VueGraphSwing vue;

    @Before
    public void setUp() {
        vue = new VueGraphSwing();
         }

    @Test
    public void testGetIncButton() {
        JButton incButton = vue.getInc();
        assertNotNull(incButton);
        assertEquals("+", incButton.getText());
    }

    @Test
    public void testGetDecButton() {
        JButton decButton = vue.getDec();
        assertNotNull(decButton);
        assertEquals("-", decButton.getText());
    }
    @Test
    public void testGetResetButton() {
        JButton resetButton = vue.getReset();
        assertNotNull(resetButton);
        assertEquals("Vider le panier", resetButton.getText());
    }

    @Test
    public void testGetBoycotteButton() {
        JButton boycotteButton = vue.getBoycotte();
        assertNotNull(boycotteButton);
        assertEquals("Boycotter", boycotteButton.getText());
    }

    @Test
    public void testGetCompteurLabel() {
        JLabel compteurLabel = vue.getCompteur();
        assertNotNull(compteurLabel);
        assertEquals("0", compteurLabel.getText());
    }

    @Test
    public void testGetShowTextArea() {
        JTextArea showTextArea = vue.getShow();
        assertNotNull(showTextArea);
        assertEquals("", showTextArea.getText());
    }

    @Test
    public void testGetPanierListComboBox() {
        JComboBox panierListComboBox = vue.getPanierList();
        assertNotNull(panierListComboBox);
       
    }

    @Test
    public void testGetCountryListComboBox() {
        JComboBox countryListComboBox = vue.getCountryList();
        assertNotNull(countryListComboBox);
       
    }

  }
