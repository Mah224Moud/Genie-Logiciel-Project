/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import org.junit.Test;
import java.lang.reflect.Field;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;

/**
 *
 * @author cristanemir
 */

public class SpecialBasketDlgTest {

    
        private SpecialBasketDlg specialBasketDlg;
    

    
    @Before
    public void setUp(){
    specialBasketDlg = new SpecialBasketDlg(null, false, new ArrayList<String>());
    }
    @Test
    public void testGetSelectedFruitFromRadio() throws Exception {
        
        
        // Créez des boutons radio simulés
        JRadioButton radio1 = Mockito.mock(JRadioButton.class);
        JRadioButton radio2 = Mockito.mock(JRadioButton.class);
        
        when(radio1.isSelected()).thenReturn(false);
        when(radio2.isSelected()).thenReturn(true);
        
        // Accédez à la variable radioButtons via la réflexion
        Field radioButtonsField = SpecialBasketDlg.class.getDeclaredField("radioButtons");
        radioButtonsField.setAccessible(true);
        List<JRadioButton> radioButtons = (List<JRadioButton>) radioButtonsField.get(specialBasketDlg);
        
        // Ajoutez les boutons radio simulés à la liste de boutons radio
        radioButtons.add(radio1);
        radioButtons.add(radio2);
        
        // Testez la méthode getSelectedFruitFromRadio
        String selectedFruit = specialBasketDlg.getSelectedFruitFromRadio();
        
        assertNull(selectedFruit); // Le premier bouton radio est désélectionné
    }
    
    @Test
    public void testGetSelectedFruitsFromCheckbox() throws Exception {
        
        // Créez des cases à cocher simulées
        JCheckBox checkbox1 = Mockito.mock(JCheckBox.class);
        JCheckBox checkbox2 = Mockito.mock(JCheckBox.class);
        
        when(checkbox1.isSelected()).thenReturn(true);
        when(checkbox2.isSelected()).thenReturn(false);
        
        // Accédez à la variable checkboxButtons via la réflexion
        Field checkboxButtonsField = SpecialBasketDlg.class.getDeclaredField("checkboxButtons");
        checkboxButtonsField.setAccessible(true);
        List<JCheckBox> checkboxButtons = (List<JCheckBox>) checkboxButtonsField.get(specialBasketDlg);
        
        // Ajoutez les cases à cocher simulées à la liste de cases à cocher
        checkboxButtons.add(checkbox1);
        checkboxButtons.add(checkbox2);
        
        // Testez la méthode getSelectedFruitsFromCheckbox
        List<String> selectedFruits = specialBasketDlg.getSelectedFruitsFromCheckbox();
        
        assertNotNull(selectedFruits); // Il y a une case à cocher sélectionnée
        assertEquals(1, selectedFruits.size()); // Il y a une case à cocher sélectionnée
        assertEquals("Fruit1", selectedFruits.get(0)); // Le premier fruit est sélectionné
    }
}


