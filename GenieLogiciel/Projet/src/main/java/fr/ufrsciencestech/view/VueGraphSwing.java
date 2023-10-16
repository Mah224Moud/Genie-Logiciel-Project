/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controller.Controleur;
import fr.ufrsciencestech.model.Modele;
import java.awt.*;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author Mamoudou
 */
public class VueGraphSwing extends JFrame implements VueG {

    private JButton inc;
    private JButton dec;
    private JButton reset;

    private JLabel affiche;

    private JPanel top;
    private JPanel buttonPanel;

    private JComboBox panierList;

    private JTextArea info;

    public VueGraphSwing() {
        super("Panier");
        instanciation();

        initComponent();

        initVariablesNames();
       

        vueSpecs();
    }

    public void vueSpecs() {
        this.pack();
        this.setVisible(true);
        this.setMinimumSize(new Dimension(800, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void instanciation() {
        inc = new JButton("+");
        dec = new JButton("-");
        reset = new JButton("Reset");

        affiche = new JLabel("0", JLabel.CENTER);

        top = new JPanel();
        buttonPanel = new JPanel();

        panierList = new JComboBox();

        info = new JTextArea();
    }

    public void initComponent() {

        panierList.setModel(new DefaultComboBoxModel<>());

        // top panel
        top.setLayout(new java.awt.GridLayout(1, 2));
        top.add(buttonPanel);
        top.add(panierList);

        // buttons panel
        buttonPanel.setLayout(new java.awt.GridLayout(1, 3));
        buttonPanel.add(inc);
        buttonPanel.add(dec);
        buttonPanel.add(reset);

        // textarea
        info.setEditable(false);

        // main panel
        add(top, BorderLayout.NORTH);
        add(affiche, BorderLayout.SOUTH);
        add(info, BorderLayout.CENTER);
    }

    public void initVariablesNames() {
        inc.setName("plus");
        dec.setName("moins");
        reset.setName("reset");
        affiche.setName("Affichage");
        info.setName("info");
    }

    public void initPanier(List<String> donnees) {
        
        panierList.removeAllItems();
        for (String element : donnees) {
            panierList.addItem(element);
        }
    }

    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getReset().addActionListener(c);
    }
    public String getSelectedPanierItem() {
    Object selectedItem = panierList.getSelectedItem();
    if (selectedItem != null) {
        return selectedItem.toString();
    }
    return null;
}


    //public void update(Observable m, Object compte){     //This method is called whenever the observed object is changed
    //      getAffiche().setText(((Integer) compte).toString());
    //}
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Modele m = (Modele) evt.getSource();
        getAffiche().setText(((Integer) m.getCompteur()).toString());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    public JButton getReset() {
        return reset;
    }

    public void setReset(JButton reset) {
        this.reset = reset;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }

    public JComboBox getPanierList() {
        return panierList;
    }

    public void setPanierList(JComboBox panierList) {
        this.panierList = panierList;
    }

    public JTextArea getInfo() {
        return info;
    }

    public void setInfo(String text) {
        info.setText(text);
    }
    
    
}
