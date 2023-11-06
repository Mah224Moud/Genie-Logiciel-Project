
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AnanasTest {
    Ananas a;

    @Before
    public void setUp() {
        a = new Ananas(0.5, "Brésil");
    }

     @After
    public void tearDown() {
        a = null;
    }
    
      @Test
    public void testGetPrix() {
        assertEquals(0.5, a.getPrix(), 0.0);
    }
    
    @Test
    public void testGetOrigine() {
        assertEquals("Brésil", a.getOrigine());
    }
    
    @Test
    public void testToString() {
        assertEquals("Ananas du Brésil à 0.5 €", a.toString());
    }
    
      @Test
    public void testIsSeedless() {
        assertFalse(a.isSeedless());
    }
    
    
}
