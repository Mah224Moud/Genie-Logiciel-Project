package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controller.Controleur;
import fr.ufrsciencestech.utils.Panier;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import static org.junit.Assert.*;
/**
 *
 * @author cristanemir
 */


public class AddDlgTest {

    private AddDlg addDlg;

    @Before
    public void setUp() {
        List<String> donnees = new ArrayList<>(); 
        addDlg = new AddDlg(null, false, donnees, new Panier(10), new Controleur());
    }

   @Test
    public void testGetCountryInput() {
        JTextField countryInput = addDlg.getCountryInputs();
        countryInput.setText("France");
        assertEquals("France", addDlg.getCountryInput());
    }

    @Test
    public void testGetPriceInput() {
        JTextField priceInput = addDlg.getPriceInputs();
        priceInput.setText("2.5");
        assertEquals("2.5", addDlg.getPriceInput());
    }

    @Test
    public void testGetAddFruit() {
        JButton addFruit = addDlg.getAddFruit();
        assertNotNull(addFruit);
    }

    @Test
    public void testGetSelectedElement() {
        JComboBox panierList = new JComboBox();
        panierList.addItem("Banane");
        panierList.setSelectedItem("Banane");
        assertEquals("Banane", panierList.getSelectedItem().toString());
    }

}




