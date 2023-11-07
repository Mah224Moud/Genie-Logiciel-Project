package fr.ufrsciencestech.controller;

import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.panier.Fruit;
import fr.ufrsciencestech.panier.Orange;
import fr.ufrsciencestech.panier.PanierPleinException;
import fr.ufrsciencestech.panier.PanierVideException;
import fr.ufrsciencestech.utils.Utils;
import fr.ufrsciencestech.view.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Controleur implements ActionListener {

    private Modele m;
    private VueG vg;
    private VueGraphSwing vue;

    /**
     * This method handles the action events from the view.
     * It first gets the action command from the action event.
     * Then it checks the action command and calls the corresponding method.
     * If the action command is "Ajouter", it calls the `add` method.
     * If the action command is "Retirer", it calls the `del` method.
     * If the action command is "Boycotter", it calls the `boycotte` method.
     * If the action command is "Effacer", it calls the `clear` method.
     *
     * @param e The action event from the view.
     * @return void
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String clicks = ((Component) e.getSource()).getName();

        switch (clicks) {
            case "plus":
                add();
                break;
            case "moins":
                del();
                break;
            case "reset":
                clear();
                break;
            case "boycotte":
                boycotte();
                break;
            case "addFruitDlg":
                AddDlg addDlg = new AddDlg(vue, true, m.getPanierList(), m.getPanier(), this);
                addDlg.setVisible(true);
                break;
            case "quit":
                vue.quit();
                break;
            case "special":
                SpecialBasketDlg special = new SpecialBasketDlg(vue, true, m.getPanierList());
                special.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Attention cette action n'est pas valide");
        }
    }

    /**
     * This method adds a fruit to the basket (panier) in the model based on the
     * selected fruit in the view.
     * It first gets the selected fruit from the view.
     * If a fruit is selected, it tries to create a new fruit object and add it to
     * the panier in the model.
     * If successful, it updates the view with the updated panier, updates the count
     * of items in the model, updates the list of countries in the view, and resets
     * the info in the model.
     * If the panier is full, it catches the PanierPleinException, displays a
     * message to the user, and logs the exception.
     * If the creation of the fruit object fails, it catches the
     * ClassNotFoundException, InstantiationException, or IllegalAccessException,
     * and logs the exception.
     *
     * @return void
     * @throws ClassNotFoundException if the class of the selected fruit does not
     *                                exist
     * @throws InstantiationException if the class of the selected fruit is abstract
     *                                or does not have a zero-argument constructor
     * @throws IllegalAccessException if the class or its zero-argument constructor
     *                                is not accessible
     * @throws PanierPleinException   if the panier in the model is full
     */
    public void add() {
        String selectedClassName = vue.getSelectedPanierItem();
        if (selectedClassName != "Choisissez un fruit") {
            try {
                Fruit fruit = Utils.createFruit("fr.ufrsciencestech.panier." + selectedClassName);
                if (fruit != null) {
                    m.getPanier().ajout(fruit);
                    vue.setShow(m.getPanier().toString());
                    m.update(1);
                    updateCountries();
                    m.setInfo("");
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (PanierPleinException ex) {
                JOptionPane.showMessageDialog(vue, ex.getMessage(), "Attention panier plein", 2);
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            m.setInfo(selectedClassName);
        }
    }

    /**
     * This method removes an item from the basket (panier) in the model and updates
     * the view.
     * It first tries to remove an item from the panier in the model.
     * If successful, it updates the list of countries in the view, displays the
     * updated panier in the view, and updates the count of items in the model.
     * If the panier is empty, it catches the PanierVideException, displays a
     * message to the user, logs the exception, and displays the exception message
     * in the view.
     *
     * @return void
     * @throws PanierVideException if the panier in the model is empty
     */
    public void del() {
        try {
            m.getPanier().retrait();
            updateCountries();
            vue.setShow(m.getPanier().toString());
            m.update(-1);
        } catch (PanierVideException ex) {
            JOptionPane.showMessageDialog(vue, ex.getMessage(), "Attention panier vide", 2);
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            vue.setShow(ex.getMessage());
        }
    }

    /**
     * This method clears the basket (panier) and resets the list of countries in
     * the model and the view.
     * It first clears the panier in the model and displays the result in the view.
     * Then it gets the list of countries from the model's panier and clears it.
     * After that, it resets the model and initializes the list of countries in the
     * view with the cleared list.
     * Finally, it sets the info in the model to an empty string.
     *
     * @return void
     */
    public void clear() {
        vue.setShow(m.getPanier().clearAll());
        List<String> countries = m.getPanier().getOrigines();
        countries.clear();
        m.reset();
        vue.initCountries(countries);
        m.setInfo("");
    }

    /**
     * This method boycotts all the fruits from the selected country.
     * It first gets the selected country from the view, then checks if a country is
     * selected.
     * 
     * If a country is selected, it calls the `boycotteOrigine` method from the
     * `Panier` object to remove all fruits from that country.
     * It then updates the view and the count of fruits in the basket.
     *
     * @return void
     */
    public void boycotte() {
        String selectCountry = vue.getSelectedCountryItem();
        m.setInfo(selectCountry);
        if (!selectCountry.equals("Choisissez un pays")) {
            m.getPanier().boycotteOrigine(selectCountry);
            vue.setShow(m.getPanier().toString());
            updateCountries();
            m.setCompteur(m.getPanier().getTaillePanier());
        }
    }

    /**
     * This method updates the list of fruits in the basket (panier) in the view.
     * It first creates a new list and adds all the fruits from the model's panier
     * to this list.
     * Then it initializes the list of fruits in the view with this list.
     * Finally, it sets the number of fruits in the model's panier.
     *
     * @return void
     */
    public void updatePanier() {
        List<String> donnees = new ArrayList<>();

        donnees.add("Choisissez un fruit");

        donnees.addAll(m.getPanierList());
        vue.initPanier(donnees);
        m.setPanier(25);
    }

    /**
     * This method updates the list of countries in the view.
     * It first gets the list of countries from the `Panier` object in the model.
     * Then it initializes the list of countries in the view with this list.
     *
     * @return void
     */
    public void updateCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("Choisissez un pays");

        countries.addAll(m.getPanier().getOrigines());
        vue.initCountries(countries);
    }

    /**
     * This method sets the model for this controller.
     * The model is where the data for the application is stored.
     *
     * @param m The model to be set for this controller.
     * @return void
     */
    public void setModele(Modele m) {
        this.m = m;
    }

    /**
     * This method sets the view for this controller.
     * It also updates the panier and the list of countries in the view.
     *
     * @param vg The view to be set for this controller.
     * @return void
     */
    public void setVue(VueG vg) {
        this.vg = vg;
        this.vue = (VueGraphSwing) vg;
        updatePanier();
        updateCountries();
    }

    /**
     * This method gets the model from this controller.
     *
     * @return Modele The model of this controller.
     */
    public Modele getM() {
        return m;
    }

    /**
     * This method gets the view from this controller.
     *
     * @return VueGraphSwing The view of this controller.
     */
    public VueGraphSwing getVue() {
        return vue;
    }

}
