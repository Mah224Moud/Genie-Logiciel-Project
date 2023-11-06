
package fr.ufrsciencestech.controller;
import org.junit.Before;
import org.junit.Test;
import java.awt.event.ActionEvent;
import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.panier.Orange;
import fr.ufrsciencestech.panier.PanierPleinException;
import fr.ufrsciencestech.utils.*;
import fr.ufrsciencestech.view.VueGraphSwing;
import static org.junit.Assert.*;


/**
 *
 * @author cristanemir
 */
public class ControleurTest {
    Controleur c1;
    Controleur c2;
    Modele m1, m2;
    Panier panier;
    Orange o;
    VueGraphSwing vueg;
    ActionEvent einc;
    ActionEvent edec;

    @Before
    public void setUp() throws PanierPleinException {
         c1 = new Controleur();
        c2 = new Controleur();
        m1 = new Modele();
        m2 = new Modele();
        panier = new Panier(2); // Créez un panier fictif
        o=new Orange(); 
        vueg = new VueGraphSwing(); 
        edec = new ActionEvent(vueg.getDec(), 1, "moins");
        einc = new ActionEvent(vueg.getInc(), 0, "plus");
    }
      @Test   //ignorer pour fonctionner dans Jenkins
    public void testActionPerformed() {
        System.out.println("actionPerformed");

        assertTrue(m1.getCompteur() == 0);
        c1.actionPerformed(einc);
        assertTrue(m1.getCompteur() == 1);

        c1.actionPerformed(edec);
        assertTrue(m1.getCompteur() == 0);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test   //ignorer pour fonctionner dans Jenkins
    public void testActionPerformedSet() {
        System.out.println("actionPerformedSet");
        assertTrue(m1.getCompteur() == 0);
        m1.setCompteur(3);
        
        c1.actionPerformed(einc);
        assertTrue(m1.getCompteur() == 4);
        
        c1.actionPerformed(edec);
        assertTrue(m1.getCompteur() == 3);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testActionPerformedVide() {
        System.out.println("actionPerformedVide");
        assertTrue(m1.getCompteur() == 0);
        
        c1.actionPerformed(edec);
        assertTrue(m1.getCompteur() == 0);
    }

    /**
     * Test of setPanier method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testSetModele() {
        System.out.println("setModele");
        c1.setModele(m2);
        c1.actionPerformed(einc);
        assertTrue(m2.getCompteur() == 1);
    }


    @Test
    public void testAddWithValidFruit() {

        c1.setVue(vueg);
        vueg.setSelectedPanierItem("Orange");
        c1.add();
        assertEquals("Le panier devrait contenir le fruit ajouté", 1, c1.getVue().getPanierList().getItemCount());
   
    }

    @Test
    public void testAddWithInvalidFruit() {
   

        c1.setVue(vueg); 

        // Exécution de la méthode add() avec un fruit invalide
        vueg.setSelectedPanierItem("Choisissez un fruit");
        c1.add();

        // Assertions pour vérifier le comportement attendu
        assertEquals("Le panier ne doit pas contenir de fruit si le choix est invalide", 0, c1.getVue().getPanierList().getItemCount());
        
      
    }


}
