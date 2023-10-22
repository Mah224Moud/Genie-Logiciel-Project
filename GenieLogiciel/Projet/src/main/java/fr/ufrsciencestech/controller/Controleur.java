package fr.ufrsciencestech.controller;

import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.panier.Fruit;
import fr.ufrsciencestech.panier.Orange;
import fr.ufrsciencestech.panier.PanierPleinException;
import fr.ufrsciencestech.panier.PanierVideException;
import fr.ufrsciencestech.view.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String clicks = ((Component) e.getSource()).getName();

        switch (clicks) {
            case "plus":
                if (!m.getPanier().estPlein()) {
                    m.update(1);
                }
                add();
                updateCountries();
                break;
            case "moins":
                m.update(-1);
                del();
                updateCountries();
                break;
            case "reset":
                m.reset();
                clear();
                break;
            case "boycotte":
                String selectCountry = vue.getSelectedCountryItem();
                m.setCountry(selectCountry);
                if (selectCountry != null) {
                    m.getPanier().boycotteOrigine(selectCountry);
                    vue.setInfo(m.getPanier().toString());
                    updateCountries();
                    m.setCompteur(m.getPanier().getTaillePanier());
                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "Attention cette action n'est pas valide");
        }
    }

    public void add() {
        String selectedClassName = vue.getSelectedPanierItem();
        if (selectedClassName != null) {
            try {
                Fruit fruit = createFruit("fr.ufrsciencestech.panier." + selectedClassName);
                if (fruit != null) {
                    m.getPanier().ajout(fruit);
                    vue.setInfo(m.getPanier().toString());
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (PanierPleinException ex) {
                JOptionPane.showMessageDialog(vue, ex.getMessage(), "Attention panier plein", 2);
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void del() {
        try {
            m.getPanier().retrait();
        } catch (PanierVideException ex) {
            JOptionPane.showMessageDialog(vue, ex.getMessage(), "Attention panier vide", 2);
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        vue.setInfo(m.getPanier().toString());
    }

    public void clear() {
        vue.setInfo(m.getPanier().clearAll());
        List<String> countries = m.getPanier().getOrigines();
        countries.clear();
        vue.initCountries(countries);
    }

    public void updatePanier() {
        List<String> donnees = m.getPanierList();
        vue.initPanier(donnees);
        m.setPanier(25);
    }

    public void updateCountries() {
        List<String> countries = m.getPanier().getOrigines();
        vue.initCountries(countries);
    }

    public void setModele(Modele m) {
        this.m = m;
    }

    public void setVue(VueG vg) {
        this.vg = vg;
        this.vue = (VueGraphSwing) vg;
        updatePanier();
        updateCountries();
    }

    public Fruit createFruit(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> fruitClass = Class.forName(className);
        if (Fruit.class.isAssignableFrom(fruitClass)) {
            Fruit instance = (Fruit) fruitClass.newInstance();
            return instance;
        } else {
            throw new IllegalArgumentException("La classe spécifiée ne doit pas être une sous-classe de Fruit.");
        }
    }

}
