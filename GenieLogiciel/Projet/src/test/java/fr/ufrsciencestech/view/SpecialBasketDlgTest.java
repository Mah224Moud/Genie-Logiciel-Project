/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.junit.*;
import java.lang.reflect.Field;
import org.mockito.*;
import static org.junit.Assert.*;

/**
 *
 * @author cristanemir
 */


public class SpecialBasketDlgTest {

    private SpecialBasketDlg specialBasketDlg;
    private JRadioButton radio1;
    private JCheckBox checkbox1;
    private JButton okButton;

    @Before
    public void setUp() {
        specialBasketDlg mock1 = new SpecialBasketDlg(vue, false, List.of("Fruit1", "Fruit2"));
     
    }

    @After
    public void tearDown() {
        specialBasketDlg.dispose();
    }

    @Test
    public void testRadioSelection() {
        // Select the radio button for "Fruit1"
        radio1.setSelected(true);
        okButton.doClick();

        String selectedFruits = specialBasketDlg.getSelectedFruitFromRadio();
        assertEquals(1, selectedFruits);
        assertTrue(selectedFruits.contains("Fruit1"));
    }

    @Test
    public void testCheckboxSelection() {
        // Select the checkbox for "Fruit1"
        checkbox1.setSelected(true);
        okButton.doClick();

        List<String> selectedFruits = specialBasketDlg.getSelectedFruitsFromCheckbox();
        assertEquals(1, selectedFruits.size());
        assertTrue(selectedFruits.contains("Fruit1"));
    }

}



