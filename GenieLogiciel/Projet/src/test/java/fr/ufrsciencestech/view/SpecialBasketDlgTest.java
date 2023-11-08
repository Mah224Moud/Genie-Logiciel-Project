/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JFrame;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertNotNull;


/**
 *
 * @author cristanemir
 */
public class SpecialBasketDlgTest {
    

    private SpecialBasketDlg specialBasketDlg;

    @Before
    public void setUp() {
       
    
 JFrame fakeFrame = new JFrame();
        List<String> testFruits = Arrays.asList("cerise", "Ananas", "Orange");
        specialBasketDlg = new SpecialBasketDlg(fakeFrame, false, testFruits);
    }
    @Test
    public void testSpecialBasketDlg() {
        // Créez un JFrame factice pour le test
        JFrame fakeFrame = new JFrame();

        // Créez une liste factice de fruits pour le test
        List<String> testFruits = Arrays.asList("cerise", "Banane", "Orange");

        // Créez une instance de SpecialBasketDlg pour le test
        SpecialBasketDlg dlg = new SpecialBasketDlg(fakeFrame, false, testFruits);

        // Vérifiez si l'instance a été créée avec succès
        assertNotNull(dlg);

        // Vérifiez les composants de l'interface utilisateur
        assertNotNull(dlg.choice);
        assertNotNull(dlg.pic);
        assertNotNull(dlg.create);
        assertNotNull(dlg.panier);

        // Testez d'autres méthodes de la classe SpecialBasketDlg ici
        // ...

        // Par exemple, testez la méthode initChoice
        dlg.initChoice();
        assertEquals(6, dlg.choice.getItemCount()); // Assurez-vous qu'il y a 3 éléments dans la liste déroulante
    }
    @Test
public void testRadioBox() {
    // Créez un JFrame factice pour le test
    JFrame fakeFrame = new JFrame();

    // Créez une liste factice de fruits pour le test
    List<String> testFruits = Arrays.asList("cerise", "Ananas", "Orange");

    // Créez une instance de SpecialBasketDlg pour le test
    SpecialBasketDlg dlg = new SpecialBasketDlg(fakeFrame, false, testFruits);

    // Appelez la méthode radioBox
    dlg.radioBox(testFruits);

    // Vérifiez le nombre de boutons radio créés
    assertEquals(testFruits.size(), dlg.radioButtons.size());
}

    
    @Test
    public void testInitChoice() {
        specialBasketDlg.initChoice();
        assertEquals(6, specialBasketDlg.choice.getItemCount());
    }

  

    @Test
    public void testCheckBox() {
        List<String> testFruits = Arrays.asList("cerise", "Ananas", "Orange");
        specialBasketDlg.checkBox(testFruits);
        assertEquals(testFruits.size(), specialBasketDlg.checkboxButtons.size());
    }

    @Test
    public void testChoiceType() {
        List<String> testFruits = Arrays.asList("cerise", "Ananas", "Orange");

        // Test when choice is "Jus de fruit simple"
        specialBasketDlg.choiceType(testFruits, "Jus de fruit simple");
        assertTrue(specialBasketDlg.centerSouth.getComponent(0) instanceof JRadioButton);
        assertEquals(testFruits.size(), specialBasketDlg.radioButtons.size());

        // Test when choice is "Jus multifruit"
        specialBasketDlg.choiceType(testFruits, "Jus multifruit");
        assertTrue(specialBasketDlg.centerSouth.getComponent(0) instanceof JCheckBox);
        assertEquals(testFruits.size(), specialBasketDlg.checkboxButtons.size());
    }

  
   

}