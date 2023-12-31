
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author salim1417
 */
public class SimpleFruitTest {
    SimpleFruit fruit;

    @Before
    public void setUp() {
        fruit = new SimpleFruit(2.0, "France");
    }

   public void tearDown() {
        fruit = null;
    }

    @Test
    public void testGetPrix() {
        assertEquals(2.0, fruit.getPrix(), 0.0);
    }
    
    @Test
    public void testSetPrixPositif() {
        fruit.setPrix(3.0);
        assertEquals(3.0, fruit.getPrix(), 0.01);
    }

    @Test
    public void testSetPrixNegatif() {
        fruit.setPrix(-1.0); 
        assertEquals(1.0, fruit.getPrix(), 0.01); // Le prix ne devrait pas être négatif
    }
    
    @Test
    public void testGetOrigine() {
        assertEquals("France", fruit.getOrigine());
    }

       
}
