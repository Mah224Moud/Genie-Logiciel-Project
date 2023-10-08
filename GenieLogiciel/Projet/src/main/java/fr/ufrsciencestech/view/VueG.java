package fr.ufrsciencestech.view;


import fr.ufrsciencestech.controller.Controleur;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author celine
 */
public interface VueG extends PropertyChangeListener { //extends Observer {
    @Override
    public void propertyChange(PropertyChangeEvent evt);
    //public void update(Observable m, Object o);
    public void addControleur(Controleur c);
    
}
