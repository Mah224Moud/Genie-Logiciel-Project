
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salim1417
 */
public class OrangeTest {
    Orange o;

    @Before
    public void setUp() {
        o = new Orange(0.9, "Etats Unies");
    }

    @Test
    public void testGetPrix() {
        assertEquals(0.9, o.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Etats Unies", o.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Orange des Etats Unies à 0.9 €", o.toString());
    }

    @Test
    public void testIsSeedless() {
        assertFalse(o.isSeedless());
    }

}
