/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.controller;
import fr.ufrsciencestech.panier.Fruit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.panier.PanierPleinException;
import fr.ufrsciencestech.view.VueGraphSwing;
import static org.junit.Assert.fail;

/**
 *
 * @author cristanemir
 */
public class ControleurTest {
         private Controleur controleur;
    private Modele modele;
    private VueGraphSwing vue;

    @Before
    public void setUp() {
        modele = Mockito.mock(Modele.class);
        vue = Mockito.mock(VueGraphSwing.class);
        controleur = new Controleur();
        controleur.setModele(modele);
        controleur.setVue(vue);
    }

    @Test(expected = PanierPleinException.class)
public void testAdd() throws PanierPleinException {
    // Simuler une action de l'utilisateur
    JComboBox<String> comboBox = new JComboBox<>(new String[] { "Banane", "Pomme" });
    Mockito.when(vue.getSelectedPanierItem()).thenReturn("Banane");
    Component source = (Component) comboBox;

    ActionEvent actionEvent = new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "plus");
    controleur.actionPerformed(actionEvent);

    // Vérifier que la méthode ajout du modèle a été appelée avec le fruit approprié
    Mockito.verify(modele.getPanier()).ajout(Mockito.any(Fruit.class));
}

    @Test
    public void testDel() {
      // Simuler une action de l'utilisateur
    JComboBox<String> comboBox = new JComboBox<>(new String[] { "Banane", "Pomme" });
    Mockito.when(vue.getSelectedPanierItem()).thenReturn("Banane");
    Component source = (Component) comboBox;

    ActionEvent actionEvent = new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "plus");

    try {
        controleur.actionPerformed(actionEvent);
        
        // Vérifier que la méthode ajout du modèle a été appelée avec le fruit approprié
        Mockito.verify(modele.getPanier()).ajout(Mockito.any(Fruit.class));
    } catch (PanierPleinException e) {
        // Gérez l'exception ici (par exemple, avec une assertion ou une autre action)
        fail("L'exception PanierPleinException ne devrait pas être levée ici.");
    }
    }

    @Test
    public void testClear() {
        // Simuler une action de l'utilisateur
        JButton button = new JButton();
        button.setName("reset");
        Component source = button;

        ActionEvent actionEvent = new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "reset");
        controleur.actionPerformed(actionEvent);

        // Vérifier que la méthode clearAll du modèle a été appelée
        Mockito.verify(modele.getPanier()).clearAll();
    }

    @Test
    public void testBoycotte() {
        // Simuler une action de l'utilisateur
        JComboBox<String> comboBox = new JComboBox<>(new String[] { "France", "Espagne" });
        Mockito.when(vue.getSelectedCountryItem()).thenReturn("France");
        Component source = (Component) comboBox;

        ActionEvent actionEvent = new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "boycotte");
        controleur.actionPerformed(actionEvent);

        // Vérifier que la méthode boycotteOrigine du modèle a été appelée avec le pays approprié
        Mockito.verify(modele.getPanier()).boycotteOrigine("France");
    }
}
