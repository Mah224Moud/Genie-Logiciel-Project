/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controller.Controleur;
import fr.ufrsciencestech.model.Modele;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;

/**
 *
 * @author celine
 */
public class VueGraphSwing extends JFrame implements VueG{
    private JButton inc;
    private JButton dec;
    private JLabel affiche;
    private JButton reset;
    private JPanel top;
    
    public VueGraphSwing(){
        super ("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        reset = new JButton("Reset");
        top = new JPanel();
        
        
        top.setLayout(new java.awt.GridLayout(1, 2));
        top.add(inc);
        top.add(dec);
        
        affiche = new JLabel("0", JLabel.CENTER);
        add(top, BorderLayout.NORTH);
        add(reset, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("plus");
        dec.setName("moins");
        reset.setName("reset");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addControleur(Controleur c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getReset().addActionListener(c);
    }
    
    
    //public void update(Observable m, Object compte){     //This method is called whenever the observed object is changed
    //      getAffiche().setText(((Integer) compte).toString());
    //}
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        Modele m = (Modele) evt.getSource();
        getAffiche().setText(((Integer)m.getCompteur()).toString());
        
        
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
}
