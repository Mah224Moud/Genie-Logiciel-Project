
package fr.ufrsciencestech.panier;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salim1417
 */
public class MangueTest {
    Mangue m;

    @Before
    public void setUp() {
        m = new Mangue(1.5, "Honduras");
    }

    @Test
    public void testGetPrix() {
        assertEquals(1.5, m.getPrix(), 0.0);
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Honduras", m.getOrigine());
    }

    @Test
    public void testToString() {
        assertEquals("Mangue du Honduras à 1.5 €", m.toString());
    }

    @Test
    public void testIsSeedless() {
        assertFalse(m.isSeedless());
    }

}
