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
            default:
                JOptionPane.showMessageDialog(null, "Attention cette action n'est pas valide");
        }
    }

    public void add() {
        String selectedClassName = vue.getSelectedPanierItem();
        if (selectedClassName != "Choisissez un fruit") {
            try {
                Fruit fruit = createFruit("fr.ufrsciencestech.panier." + selectedClassName);
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

    public void del() {
        try {
            m.getPanier().retrait();
            updateCountries();
            m.update(-1);
        } catch (PanierVideException ex) {
            JOptionPane.showMessageDialog(vue, ex.getMessage(), "Attention panier vide", 2);
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            vue.setShow(ex.getMessage());
        }
    }

    public void clear() {
        vue.setShow(m.getPanier().clearAll());
        List<String> countries = m.getPanier().getOrigines();
        countries.clear();
        m.reset();
        vue.initCountries(countries);
        m.setInfo("");
    }

    public void boycotte() {
        String selectCountry = vue.getSelectedCountryItem();
        m.setInfo(selectCountry);
        if (selectCountry != "Choisissez un pays") {
            m.getPanier().boycotteOrigine(selectCountry);
            vue.setShow(m.getPanier().toString());
            updateCountries();
            m.setCompteur(m.getPanier().getTaillePanier());
        }
    }

    public void updatePanier() {
        List<String> donnees = new ArrayList<>();

        donnees.add("Choisissez un fruit");

        donnees.addAll(m.getPanierList());
        vue.initPanier(donnees);
        m.setPanier(25);
    }

    public void updateCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("Choisissez un pays");

        countries.addAll(m.getPanier().getOrigines());
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
