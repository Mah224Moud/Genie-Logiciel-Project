
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salim1417
 */
public class FraiseTest {
    Fraise f;

    @Before
    public void setUp() {
        f = new Fraise(0.35, "Hawai");
    }

    @Test
    public void testGetPrix() {
        assertEquals(0.35, f.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Hawai", f.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Fraise de Hawai à 0.35 €", f.toString());
    }

    @Test
    public void testIsSeedless() {
        assertFalse(f.isSeedless());
    }

   
}
