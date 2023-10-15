package fr.ufrsciencestech.controller;

import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.panier.Fruit;
import fr.ufrsciencestech.panier.Orange;
import fr.ufrsciencestech.panier.PanierPleinException;
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

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof JButton) {
        // L'action est déclenchée par un bouton
        JButton sourceButton = (JButton) e.getSource();
        String buttonName = sourceButton.getName();

        switch (buttonName) {
            case "plus":
                m.update(1);
                break;
            case "moins":
                m.update(-1);
                break;
            case "reset":
                m.reset();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Attention cette action n'est pas valide");
        }
    } else if (e.getSource() instanceof JComboBox) {
        // L'action est déclenchée par la liste (JComboBox)
        JComboBox<String> sourceList = (JComboBox<String>) e.getSource();
        String selectedValue = (String) sourceList.getSelectedItem();
        
        
        System.out.println(selectedValue);
        
    }
}


    public void updatePanier(){
        List<String> donnees = m.getPanierList();
        vg.initPanier(donnees);
        m.setPanier(25);
        
        /*Fruit orange = new Orange();
        try {
            m.getPanier().ajout(orange);
        } catch (PanierPleinException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Panier info"+m.getPanier().getFruits());*/
    }
    
    
    public void setModele(Modele m) {
        this.m = m;
    }

    public void setVue(VueG vg) {
        this.vg = vg;
        updatePanier();
    }
}
