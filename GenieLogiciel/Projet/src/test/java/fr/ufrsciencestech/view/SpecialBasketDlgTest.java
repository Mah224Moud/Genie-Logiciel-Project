
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
    private JFrame parentFrame;
    private List<String> fruits;

    @Before
    public void setUp() {
        parentFrame = new JFrame();
        fruits = new ArrayList<>();
        fruits.add("Fruit1");
        fruits.add("Fruit2");
        specialBasketDlg = new SpecialBasketDlg(parentFrame, true, fruits);

    }

        @Test
        public void testGetSelectedFruitFromRadio() {
            // Sélectionnez un bouton radio dans le test
            specialBasketDlg.radioButtons.get(0).setSelected(true); 
            String expectedFruit = "Fruit1";
            String actualFruit = specialBasketDlg.getSelectedFruitFromRadio();
            assertEquals(expectedFruit, actualFruit);
        }

    /*@Test
    public void testGetSelectedFruitsFromCheckbox() {
        // Sélectionnez les cases à cocher dans le test
        specialBasketDlg.checkboxButtons.get(0).setSelected(true); // Sélectionnez le premier fruit
        specialBasketDlg.checkboxButtons.get(i) // Sélectionnez le deuxième fruit

        List<String> expectedFruits = new ArrayList<>();
        expectedFruits.add("Fruit1");
        expectedFruits.add("Fruit2");

        List<String> actualFruits = specialBasketDlg.getSelectedFruitsFromCheckbox();
        assertEquals(expectedFruits, actualFruits);
    }*/

    @Test
    public void testGetChoice() {
        String expectedChoice = "Jus de fruit simple";
        String actualChoice = specialBasketDlg.getChoice();
        assertEquals(expectedChoice, actualChoice);
    }

    /*@Test
    public void testUpdatePicIcon() {
    
    }*/

  

}



